package ds.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: proto/petrol_station_new_data.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PetrolStationNewDataGrpc {

  private PetrolStationNewDataGrpc() {}

  public static final String SERVICE_NAME = "petrolStationNewData.PetrolStationNewData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.grpc.PetrolStationPredictionRequest,
      ds.grpc.PetrolStationPredictionResponse> getPricePredictionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PricePrediction",
      requestType = ds.grpc.PetrolStationPredictionRequest.class,
      responseType = ds.grpc.PetrolStationPredictionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.grpc.PetrolStationPredictionRequest,
      ds.grpc.PetrolStationPredictionResponse> getPricePredictionMethod() {
    io.grpc.MethodDescriptor<ds.grpc.PetrolStationPredictionRequest, ds.grpc.PetrolStationPredictionResponse> getPricePredictionMethod;
    if ((getPricePredictionMethod = PetrolStationNewDataGrpc.getPricePredictionMethod) == null) {
      synchronized (PetrolStationNewDataGrpc.class) {
        if ((getPricePredictionMethod = PetrolStationNewDataGrpc.getPricePredictionMethod) == null) {
          PetrolStationNewDataGrpc.getPricePredictionMethod = getPricePredictionMethod =
              io.grpc.MethodDescriptor.<ds.grpc.PetrolStationPredictionRequest, ds.grpc.PetrolStationPredictionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PricePrediction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.grpc.PetrolStationPredictionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.grpc.PetrolStationPredictionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PetrolStationNewDataMethodDescriptorSupplier("PricePrediction"))
              .build();
        }
      }
    }
    return getPricePredictionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PetrolStationNewDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetrolStationNewDataStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetrolStationNewDataStub>() {
        @java.lang.Override
        public PetrolStationNewDataStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetrolStationNewDataStub(channel, callOptions);
        }
      };
    return PetrolStationNewDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PetrolStationNewDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetrolStationNewDataBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetrolStationNewDataBlockingStub>() {
        @java.lang.Override
        public PetrolStationNewDataBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetrolStationNewDataBlockingStub(channel, callOptions);
        }
      };
    return PetrolStationNewDataBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PetrolStationNewDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetrolStationNewDataFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetrolStationNewDataFutureStub>() {
        @java.lang.Override
        public PetrolStationNewDataFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetrolStationNewDataFutureStub(channel, callOptions);
        }
      };
    return PetrolStationNewDataFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PetrolStationNewDataImplBase implements io.grpc.BindableService {

    /**
     */
    public void pricePrediction(ds.grpc.PetrolStationPredictionRequest request,
        io.grpc.stub.StreamObserver<ds.grpc.PetrolStationPredictionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPricePredictionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPricePredictionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.grpc.PetrolStationPredictionRequest,
                ds.grpc.PetrolStationPredictionResponse>(
                  this, METHODID_PRICE_PREDICTION)))
          .build();
    }
  }

  /**
   */
  public static final class PetrolStationNewDataStub extends io.grpc.stub.AbstractAsyncStub<PetrolStationNewDataStub> {
    private PetrolStationNewDataStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetrolStationNewDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetrolStationNewDataStub(channel, callOptions);
    }

    /**
     */
    public void pricePrediction(ds.grpc.PetrolStationPredictionRequest request,
        io.grpc.stub.StreamObserver<ds.grpc.PetrolStationPredictionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPricePredictionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PetrolStationNewDataBlockingStub extends io.grpc.stub.AbstractBlockingStub<PetrolStationNewDataBlockingStub> {
    private PetrolStationNewDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetrolStationNewDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetrolStationNewDataBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.grpc.PetrolStationPredictionResponse pricePrediction(ds.grpc.PetrolStationPredictionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPricePredictionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PetrolStationNewDataFutureStub extends io.grpc.stub.AbstractFutureStub<PetrolStationNewDataFutureStub> {
    private PetrolStationNewDataFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetrolStationNewDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetrolStationNewDataFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.grpc.PetrolStationPredictionResponse> pricePrediction(
        ds.grpc.PetrolStationPredictionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPricePredictionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRICE_PREDICTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PetrolStationNewDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PetrolStationNewDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRICE_PREDICTION:
          serviceImpl.pricePrediction((ds.grpc.PetrolStationPredictionRequest) request,
              (io.grpc.stub.StreamObserver<ds.grpc.PetrolStationPredictionResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PetrolStationNewDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PetrolStationNewDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.grpc.PetrolStationNewDataProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PetrolStationNewData");
    }
  }

  private static final class PetrolStationNewDataFileDescriptorSupplier
      extends PetrolStationNewDataBaseDescriptorSupplier {
    PetrolStationNewDataFileDescriptorSupplier() {}
  }

  private static final class PetrolStationNewDataMethodDescriptorSupplier
      extends PetrolStationNewDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PetrolStationNewDataMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PetrolStationNewDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PetrolStationNewDataFileDescriptorSupplier())
              .addMethod(getPricePredictionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
