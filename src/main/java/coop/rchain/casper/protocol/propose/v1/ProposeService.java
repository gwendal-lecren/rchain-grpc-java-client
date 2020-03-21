package coop.rchain.casper.protocol.propose.v1;

import coop.rchain.AbstractClient;
import coop.rchain.casper.protocol.ProposeServiceCommon;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class ProposeService extends AbstractClient {

    ProposeService(Builder builder) {
        super(builder);
    }

    public ProposeService(Channel channel) {
        this(new Builder(ProposeServiceGrpc.newBlockingStub(channel), ProposeServiceGrpc.newStub(channel)));
    }

    public ProposeService(String target) {
        this(ManagedChannelBuilder.forTarget(target).build());
    }

    public static final class Builder extends AbstractClient.Builder<ProposeServiceGrpc.ProposeServiceBlockingStub,
            ProposeServiceGrpc.ProposeServiceStub> {
        public Builder(ProposeServiceGrpc.ProposeServiceBlockingStub blockingStub, ProposeServiceGrpc.ProposeServiceStub asyncStub) {
            super(blockingStub, asyncStub);
        }

        @Override
        public ProposeService build() {
            return new ProposeService(this);
        }

        @Override
        public Builder setBlockingStub(ProposeServiceGrpc.ProposeServiceBlockingStub blockingStub) {
            return (Builder) super.setBlockingStub(blockingStub);
        }

        @Override
        public Builder setAsyncStub(ProposeServiceGrpc.ProposeServiceStub asyncStub) {
            return (Builder) super.setAsyncStub(asyncStub);
        }
    }


    public ProposeServiceV1.ProposeResponse propose(ProposeServiceCommon.PrintUnmatchedSendsQuery request) {
        return ((ProposeServiceGrpc.ProposeServiceBlockingStub) this.blockingStub).propose(request);
    }

}
