

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import xdi2.agent.impl.XDIBasicAgent;
import xdi2.agent.routing.XDIAgentRouter;
import xdi2.agent.routing.impl.bootstrap.XDIBootstrapLocalAgentRouter;
import xdi2.agent.routing.impl.local.XDILocalAgentRouter;
import xdi2.client.impl.local.XDILocalClient;
import xdi2.core.ContextNode;
import xdi2.core.Graph;
import xdi2.core.features.aggregation.Aggregation;
import xdi2.core.features.linkcontracts.instance.RootLinkContract;
import xdi2.core.features.nodetypes.XdiEntityCollection;
import xdi2.core.features.nodetypes.XdiEntityInstance;
import xdi2.core.features.nodetypes.XdiInnerRoot;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.core.syntax.XDIAddress;
import xdi2.core.syntax.XDIArc;
import xdi2.core.syntax.XDIStatement;
import xdi2.core.util.CopyUtil;
import xdi2.core.util.CopyUtil.ExtractXDIAddressCopyStrategy;
import xdi2.core.util.GraphUtil;
import xdi2.core.util.XDIAddressUtil;
import xdi2.core.util.iterators.CompositeIterator;
import xdi2.core.util.iterators.IteratorListMaker;
import xdi2.core.util.iterators.NotNullIterator;
import xdi2.core.util.iterators.ReadOnlyIterator;
import xdi2.messaging.Message;
import xdi2.messaging.MessageEnvelope;
import xdi2.messaging.container.impl.graph.GraphMessagingContainer;
import xdi2.messaging.container.interceptor.impl.connect.ConnectInterceptor;
import xdi2.messaging.container.interceptor.impl.security.signature.SignatureInterceptor;
import xdi2.messaging.container.interceptor.impl.send.SendInterceptor;
import xdi2.messaging.operations.ConnectOperation;
import xdi2.messaging.operations.DelOperation;
import xdi2.messaging.operations.GetOperation;
import xdi2.messaging.operations.Operation;
import xdi2.messaging.operations.SetOperation;
import xdi2.messaging.response.TransportMessagingResponse;

public class AevatarMain extends AevatarMainUI {

	public AevatarMain() {

		super();
		initComponents();
		try {
			initXdi();
		} catch (Exception ex) {
			this.error(ex);
		}
	}

	private void initComponents() {

		Util.initJFrame(this);
	}

	private Graph aliceGraph;
	private XDILocalClient aliceLocalClient;

	private void initXdi() throws Exception {

		aliceGraph = MemoryGraphFactory.getInstance().openGraph();
		GraphMessagingContainer aliceContainer = new GraphMessagingContainer(aliceGraph);
		aliceContainer.addStandardExtensions();
		XDIBasicAgent aliceAgent = new XDIBasicAgent(new XDIAgentRouter<?, ?> [] { new XDIBootstrapLocalAgentRouter(), new XDILocalAgentRouter(aliceContainer) } );
		aliceContainer.getInterceptors().findInterceptor(SendInterceptor.class).setXdiAgent(aliceAgent);
		aliceContainer.getInterceptors().findInterceptor(ConnectInterceptor.class).setXdiAgent(aliceAgent);
		aliceContainer.getInterceptors().removeInterceptor(aliceContainer.getInterceptors().findInterceptor(SignatureInterceptor.class));

		// XDI-DATA-ALICE-1: Self-asserted basic profile data

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-1.xdi")), aliceGraph, null);

		// XDI-DATA-ALICE-2: Linking unlisted identifier to Ævatar ID

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-2.xdi")), aliceGraph, null);

		// XDI-DATA-ALICE-3: Standard link contract that enables first contact

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-3.xdi")), aliceGraph, null);

		// XDI-DATA-ALICE-5: Medical records in Alice's identity container

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-5.xdi")), aliceGraph, null);

		// prepare transport to execute messages against container

		aliceLocalClient = new XDILocalClient(aliceContainer);
	}

	protected void aliceViewIdentityContainerActionPerformed(ActionEvent e) {

		// display to the user

		display(this.aliceGraph);
	}

	protected void aliceViewMedicalRecordsActionPerformed(ActionEvent e) {

		try {

			Graph tempGraph = GraphUtil.graph();
			ContextNode contextNode1111 = this.aliceGraph.getDeepContextNode(XDIAddress.create("=!:uuid:1111#medical[#record]"));
			ContextNode contextNode1a1a = this.aliceGraph.getDeepContextNode(XDIAddress.create("=!:uuid:1a1a#medical[#record]"));
			if (contextNode1111 != null) CopyUtil.copyContextNode(contextNode1111, tempGraph, null);
			if (contextNode1a1a != null) CopyUtil.copyContextNode(contextNode1a1a, tempGraph, null);

			// build human-readable interpretation

			StringBuffer interpretation = new StringBuffer();

			List<XdiEntityInstance> instances = new ArrayList<XdiEntityInstance> ();
			if (contextNode1111 != null) instances.addAll(new IteratorListMaker(XdiEntityCollection.fromContextNode(contextNode1111).getXdiInstances()).list());
			if (contextNode1a1a != null) instances.addAll(new IteratorListMaker(XdiEntityCollection.fromContextNode(contextNode1a1a).getXdiInstances()).list());

			for (XdiEntityInstance instance : instances) {

				interpretation.append("Medical record " + instance.getXDIAddress() + ":\n");

				interpretation.append("--> Blood pressure: " + instance.getXdiAttributeSingleton(XDIAddress.create("<#blood><#pressure>"), false).getLiteralData() + "\n");
				interpretation.append("--> Blood sugar: " + instance.getXdiAttributeSingleton(XDIAddress.create("<#blood><#sugar>"), false).getLiteralData() + "\n");
				interpretation.append("--> Pulse: " + instance.getXdiAttributeSingleton(XDIAddress.create("<#pulse>"), false).getLiteralData() + "\n");
				interpretation.append("--> Weight: " + instance.getXdiAttributeSingleton(XDIAddress.create("<#weight>"), false).getLiteralData() + "\n");

				interpretation.append("\n");
			}

			// display to the user

			display(tempGraph, interpretation.toString());
		} catch (Exception ex) {

			error(ex);
		}
	}

	protected void doctorSendRequestMedicalRecordsActionPerformed(ActionEvent e) {

		try {

			// XDI-MSG-5: send request for medical records to Alice's identity container

			MessageEnvelope me = MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-msg-5.xdi")));

			TransportMessagingResponse response = aliceLocalClient.send(me);

			// display to the user

			display(response.getGraph());
		} catch (Exception ex) {

			error(ex);
		}
	}

	private List<Message> pendingMessages;

	protected void aliceViewPendingMessagesActionPerformed(ActionEvent e) {

		try {

			// look up pending messages in Alice's identity container

			MessageEnvelope me = new MessageEnvelope();
			Message m = me.createMessage(Constants.XDI_ADD_ALICE_AVATAR_ID);
			m.setToXDIAddress(Constants.XDI_ADD_ALICE_AVATAR_ID);
			m.setLinkContractClass(RootLinkContract.class);

			m.createGetOperation(XDIAddress.create("[$msg]"));

			TransportMessagingResponse response = aliceLocalClient.send(me);

			// extract and remember incoming requests in Alice's identity container

			Graph tempGraph = GraphUtil.graph();
			CopyUtil.copyGraph(response.getResultGraph(), tempGraph, new ExtractXDIAddressCopyStrategy(XdiInnerRoot.class, false, false, false, false, true));

			pendingMessages = new ArrayList<Message> ();
			ContextNode pendingMessagesContextNodes = tempGraph.getDeepContextNode(XDIAddress.create("[$msg]"));
			for (ContextNode pendingMessageContextNode : Aggregation.getAggregationContextNodes(pendingMessagesContextNodes)) {

				Message pendingMessage = Message.fromContextNode(pendingMessageContextNode);
				pendingMessages.add(pendingMessage);
			}

			// build human-readable interpretation

			StringBuffer interpretation = new StringBuffer();

			for (Message pendingMessage : pendingMessages) {

				interpretation.append(pendingMessage.getSenderXDIAddress() + " is sending you a request...\n");

				for (Operation operation : pendingMessage.getOperations()) {

					interpretation.append("--> to ");

					if (operation instanceof GetOperation)
						interpretation.append("GET");
					else if (operation instanceof SetOperation)
						interpretation.append("SET");
					else if (operation instanceof DelOperation)
						interpretation.append("DELETE");
					else if (operation instanceof ConnectOperation)
						interpretation.append("CREATE LINK CONTRACT FOR");
					else
						interpretation.append("(?DO SOMETHING UNKNOWN?) TO");

					interpretation.append(" the following: \n");

					if (operation.getTargetXDIAddress() != null)
						interpretation.append("----> " + operation.getTargetXDIAddress() + "\n");

					if (operation.getTargetXDIStatements() != null) for (XDIStatement targetXDIStatement : operation.getTargetXDIStatements())
						interpretation.append("----> " + targetXDIStatement + "\n");

					if (! operation.getVariableValues().isEmpty()) {

						for (Map.Entry<XDIArc, Object> entry : operation.getVariableValues().entrySet()) {

							interpretation.append("----> VARIABLE: " + entry.getKey() + " -> " + entry.getValue() + "\n");
						}

					}
				}

				interpretation.append("\n\n");
			}

			// display to the user

			display(tempGraph, interpretation.toString());
		} catch (Exception ex) {

			error(ex);
		}
	}

	protected void aliceModifyIncomingRequestActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	protected void aliceApprovePendingMessagesActionPerformed(ActionEvent e) {

		try {

			// approve pending messages in Alice's identity container

			MessageEnvelope me = new MessageEnvelope();
			Message m = me.createMessage(Constants.XDI_ADD_ALICE_AVATAR_ID);
			m.setToXDIAddress(Constants.XDI_ADD_ALICE_AVATAR_ID);
			m.setLinkContractClass(RootLinkContract.class);

			for (Message pendingMessage : pendingMessages) {

				m.createSendOperation(pendingMessage);
				m.createDelOperation(pendingMessage.getContextNode().getXDIAddress());
			}

			TransportMessagingResponse response = aliceLocalClient.send(me);

			// display to the user

			display(response.getGraph());
		} catch (Exception ex) {

			error(ex);
		}
	}

	protected void aliceRejectPendingMessagesActionPerformed(ActionEvent e) {

		try {

			// delete pending messages in Alice's identity container

			MessageEnvelope me = new MessageEnvelope();
			Message m = me.createMessage(Constants.XDI_ADD_ALICE_AVATAR_ID);
			m.setToXDIAddress(Constants.XDI_ADD_ALICE_AVATAR_ID);
			m.setLinkContractClass(RootLinkContract.class);

			for (Message pendingMessage : pendingMessages) {

				m.createDelOperation(XDIAddressUtil.concatXDIAddresses(XDIAddress.create("(=!:uuid:3c3c/=!:uuid:1111)"), pendingMessage.getContextNode().getXDIAddress()));
			}

			TransportMessagingResponse response = aliceLocalClient.send(me);

			// display to the user

			display(response.getGraph());
		} catch (Exception ex) {

			error(ex);
		}
	}

	protected void doctorSendNewMedicalRecordActionPerformed(ActionEvent e) {

		try {

			// XDI-MSG-7: add new medical record to Alice's identity container

			MessageEnvelope me = MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-msg-7.xdi")));

			TransportMessagingResponse response = aliceLocalClient.send(me);

			// display to the user

			display(response.getGraph());
		} catch (Exception ex) {

			error(ex);
		}
	}

	private void display(Graph g, String text) {

		JFrame frame = new AevatarXdi(g, text);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	private void display(Graph g) {

		display(g, "");
	}

	private void error(Exception ex) {

		ex.printStackTrace(System.err);

		JOptionPane.showMessageDialog(null, (ex.getMessage() != null && ex.getMessage().length() > 1) ? ex.getMessage() : ex.getClass().getName());
	}
}
