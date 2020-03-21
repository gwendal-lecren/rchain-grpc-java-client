package coop.rchain;

import com.google.common.base.Preconditions;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;

/**
 * Abstract client for RChain gRPC API
 */
public class AbstractClient<T extends AbstractBlockingStub, U extends AbstractAsyncStub> {

    protected final T blockingStub;
    protected final U asyncStub;

    protected AbstractClient(Builder builder) {
        blockingStub = (T) builder.blockingStub;
        asyncStub = (U) builder.asyncStub;
    }

    public abstract static class Builder<T extends AbstractBlockingStub, U extends AbstractAsyncStub> {
        T blockingStub;
        U asyncStub;

        protected Builder(T blockingStub, U asyncStub) {
            this.blockingStub = Preconditions.checkNotNull(blockingStub);
            this.asyncStub = Preconditions.checkNotNull(asyncStub);
        }

        public abstract AbstractClient build();

        public Builder setBlockingStub(T blockingStub) {
            this.blockingStub = (T) blockingStub;
            return this;
        }

        public Builder setAsyncStub(U asyncStub) {
            this.asyncStub = (U) asyncStub;
            return this;
        }

    }


}
