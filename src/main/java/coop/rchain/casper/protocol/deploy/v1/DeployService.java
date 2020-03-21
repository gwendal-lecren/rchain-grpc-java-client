package coop.rchain.casper.protocol.deploy.v1;

import coop.rchain.AbstractClient;
import coop.rchain.casper.protocol.CasperMessage;
import coop.rchain.casper.protocol.DeployServiceCommon;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class DeployService extends AbstractClient {


    DeployService(Builder builder) {
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
        public DeployService build() {
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

    /**
     * Queue deployment of Rholang code (or fail to parse)
     */
    public DeployServiceV1.DeployResponse doDeploy(CasperMessage.DeployDataProto request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).doDeploy(request);
    }

    /**
     * Get details about a particular block
     */
    public DeployServiceV1.BlockResponse getBlock(DeployServiceCommon.BlockQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).getBlock(request);
    }

    /**
     * Get dag
     */
    public Iterator<DeployServiceV1.VisualizeBlocksResponse> visualizeDag(DeployServiceCommon.VisualizeDagQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).visualizeDag(request);
    }

    public DeployServiceV1.MachineVerifyResponse machineVerifiableDag(DeployServiceCommon.MachineVerifyQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).machineVerifiableDag(request);
    }

    /*
     * Returns on success LightBlockInfo
     */
    public Iterator<DeployServiceV1.BlockInfoResponse> showMainChain(DeployServiceCommon.BlocksQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).showMainChain(request);
    }

    /**
     * Get a summary of blocks on the blockchain
     */
    public Iterator<DeployServiceV1.BlockInfoResponse> getBlocks(DeployServiceCommon.BlocksQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).getBlocks(request);
    }

    /**
     * Find data sent to a name
     */
    public DeployServiceV1.ListeningNameDataResponse listenForDataAtName(DeployServiceCommon.DataAtNameQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).listenForDataAtName(request);
    }

    /**
     * Find processes receiving on a name
     */
    public DeployServiceV1.ContinuationAtNameResponse listenForContinuationAtName(DeployServiceCommon.ContinuationAtNameQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).listenForContinuationAtName(request);
    }

    /**
     * Find block containing a deploy
     */
    public DeployServiceV1.FindDeployResponse findDeploy(DeployServiceCommon.FindDeployQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).findDeploy(request);
    }

    /**
     * Preview new top-level unforgeable names (for example, to compute signatures over them)
     */
    public DeployServiceV1.PrivateNamePreviewResponse previewPrivateNames(DeployServiceCommon.PrivateNamePreviewQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).previewPrivateNames(request);
    }

    /**
     * Get details about a particular block
     */
    public DeployServiceV1.LastFinalizedBlockResponse lastFinalizedBlock(DeployServiceCommon.LastFinalizedBlockQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).lastFinalizedBlock(request);
    }

    /**
     * Check if a given block is finalized
     */
    public DeployServiceV1.IsFinalizedResponse isFinalized(DeployServiceCommon.IsFinalizedQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).isFinalized(request);
    }

    /**
     * Check if a given validator is bonded
     */
    public DeployServiceV1.BondStatusResponse bondStatus(DeployServiceCommon.BondStatusQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).bondStatus(request);
    }

    /**
     * Executes deploy as user deploy with immediate rollback and return result
     */
    public DeployServiceV1.ExploratoryDeployResponse exploratoryDeploy(DeployServiceCommon.ExploratoryDeployQuery request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).exploratoryDeploy(request);
    }

    /**
     * Get blocks by block height
     */
    public Iterator<DeployServiceV1.BlockInfoResponse> getBlocksByHeights(DeployServiceCommon.BlocksQueryByHeight request) {
        return ((DeployServiceGrpc.DeployServiceBlockingStub) this.blockingStub).getBlocksByHeights(request);
    }

}
