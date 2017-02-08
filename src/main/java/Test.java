import java.io.File;

import xdi2.core.Graph;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.core.impl.wrapped.file.FileWrapperGraphFactory;
import xdi2.core.util.CopyUtil;
import xdi2.messaging.MessageEnvelope;
import xdi2.messaging.container.impl.graph.GraphMessagingContainer;
import xdi2.transport.impl.local.LocalTransport;
import xdi2.transport.impl.local.LocalTransportRequest;
import xdi2.transport.impl.local.LocalTransportResponse;

public class Test {

	public static void main(String[] args) throws Exception {

		FileWrapperGraphFactory aliceGraphFactory = new FileWrapperGraphFactory();
		aliceGraphFactory.setPath("alice-graph.xdi");
		aliceGraphFactory.setMimeType("text/xdi");
		Graph aliceGraph = aliceGraphFactory.openGraph();
		GraphMessagingContainer aliceContainer = new GraphMessagingContainer(aliceGraph);
		aliceContainer.addStandardExtensions();

		// XDI-DATA-ALICE-1: Self-asserted basic profile data

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-1.xdi")), aliceGraph, null);

		// XDI-DATA-ALICE-2: Linking unlisted identifier to Ævatar ID

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-2.xdi")), aliceGraph, null);

		// XDI-DATA-ALICE-3: Standard link contract that enables first contact

		CopyUtil.copyGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-data-alice-3.xdi")), aliceGraph, null);

		// prepare transport to execute messages against container

		LocalTransport transport = new LocalTransport(aliceContainer);

		// XDI-MSG-5: Request for data: Doctor → Alice

		MessageEnvelope me1 = MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(new File("xdi-msg-5.xdi")));

		LocalTransportRequest req1 = new LocalTransportRequest(me1);
		LocalTransportResponse resp2 = new LocalTransportResponse();

		transport.execute(req1, resp2);

		System.out.println(resp2.getMessagingResponse().getGraph().toString("XDI DISPLAY"));

		// done

		aliceGraph.close();
	}
}
