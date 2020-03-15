package coop.rchain.comm.protocol.routing;

import coop.rchain.AbstractClient;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class TransportLayer extends AbstractClient {


    protected TransportLayer(Builder builder) {
        super(builder);
    }

    public TransportLayer(Channel channel) {
        this(new TransportLayer.Builder(TransportLayerGrpc.newBlockingStub(channel), TransportLayerGrpc.newStub(channel)));
    }

    public TransportLayer(String target) {
        this(ManagedChannelBuilder.forTarget(target).build());
    }

    public static final class Builder extends AbstractClient.Builder<TransportLayerGrpc.TransportLayerBlockingStub,
            TransportLayerGrpc.TransportLayerStub> {
        public Builder(TransportLayerGrpc.TransportLayerBlockingStub blockingStub, TransportLayerGrpc.TransportLayerStub asyncStub) {
            super(blockingStub, asyncStub);
        }

        @Override
        public AbstractClient build() {
            return new TransportLayer(this);
        }

        @Override
        public TransportLayer.Builder setBlockingStub(TransportLayerGrpc.TransportLayerBlockingStub blockingStub) {
            return (Builder) super.setBlockingStub(blockingStub);
        }

        @Override
        public TransportLayer.Builder setAsyncStub(TransportLayerGrpc.TransportLayerStub asyncStub) {
            return (Builder) super.setAsyncStub(asyncStub);
        }
    }

    // todo implement api methods


}
