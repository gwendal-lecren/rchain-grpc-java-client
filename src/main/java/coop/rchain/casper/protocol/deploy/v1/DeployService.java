package coop.rchain.casper.protocol.deploy.v1;

import coop.rchain.AbstractClient;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class DeployService extends AbstractClient {


    protected DeployService(Builder builder) {
        super(builder);
    }

    public DeployService(Channel channel) {
        this(new DeployService.Builder(DeployServiceGrpc.newBlockingStub(channel), DeployServiceGrpc.newStub(channel)));
    }

    public DeployService(String target) {
        this(ManagedChannelBuilder.forTarget(target).build());
    }

    public static final class Builder extends AbstractClient.Builder<DeployServiceGrpc.DeployServiceBlockingStub,
            DeployServiceGrpc.DeployServiceStub> {
        public Builder(DeployServiceGrpc.DeployServiceBlockingStub blockingStub, DeployServiceGrpc.DeployServiceStub asyncStub) {
            super(blockingStub, asyncStub);
        }

        @Override
        public AbstractClient build() {
            return new DeployService(this);
        }

        @Override
        public DeployService.Builder setBlockingStub(DeployServiceGrpc.DeployServiceBlockingStub blockingStub) {
            return (Builder) super.setBlockingStub(blockingStub);
        }

        @Override
        public DeployService.Builder setAsyncStub(DeployServiceGrpc.DeployServiceStub asyncStub) {
            return (Builder) super.setAsyncStub(asyncStub);
        }
    }

    // todo implement api methods

}
