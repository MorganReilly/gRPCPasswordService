package ie.gmit.ds;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: password.proto")
public final class PasswordServiceGrpc {

  private PasswordServiceGrpc() {}

  public static final String SERVICE_NAME = "ie.gmit.ds.PasswordService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.PasswordRequest,
      com.google.protobuf.BoolValue> getAddHashMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddHash",
      requestType = ie.gmit.ds.PasswordRequest.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.PasswordRequest,
      com.google.protobuf.BoolValue> getAddHashMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.PasswordRequest, com.google.protobuf.BoolValue> getAddHashMethod;
    if ((getAddHashMethod = PasswordServiceGrpc.getAddHashMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getAddHashMethod = PasswordServiceGrpc.getAddHashMethod) == null) {
          PasswordServiceGrpc.getAddHashMethod = getAddHashMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.PasswordRequest, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddHash"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.PasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("AddHash"))
              .build();
        }
      }
    }
    return getAddHashMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.PasswordResponse> getGetHashMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHash",
      requestType = com.google.protobuf.Empty.class,
      responseType = ie.gmit.ds.PasswordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.PasswordResponse> getGetHashMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ie.gmit.ds.PasswordResponse> getGetHashMethod;
    if ((getGetHashMethod = PasswordServiceGrpc.getGetHashMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getGetHashMethod = PasswordServiceGrpc.getGetHashMethod) == null) {
          PasswordServiceGrpc.getGetHashMethod = getGetHashMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ie.gmit.ds.PasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHash"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.PasswordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("GetHash"))
              .build();
        }
      }
    }
    return getGetHashMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.ValidateRequest,
      com.google.protobuf.BoolValue> getAddValidationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddValidation",
      requestType = ie.gmit.ds.ValidateRequest.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.ValidateRequest,
      com.google.protobuf.BoolValue> getAddValidationMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.ValidateRequest, com.google.protobuf.BoolValue> getAddValidationMethod;
    if ((getAddValidationMethod = PasswordServiceGrpc.getAddValidationMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getAddValidationMethod = PasswordServiceGrpc.getAddValidationMethod) == null) {
          PasswordServiceGrpc.getAddValidationMethod = getAddValidationMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.ValidateRequest, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddValidation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.ValidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("AddValidation"))
              .build();
        }
      }
    }
    return getAddValidationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.ValidateResponse> getGetValidationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetValidation",
      requestType = com.google.protobuf.Empty.class,
      responseType = ie.gmit.ds.ValidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.ValidateResponse> getGetValidationMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ie.gmit.ds.ValidateResponse> getGetValidationMethod;
    if ((getGetValidationMethod = PasswordServiceGrpc.getGetValidationMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getGetValidationMethod = PasswordServiceGrpc.getGetValidationMethod) == null) {
          PasswordServiceGrpc.getGetValidationMethod = getGetValidationMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ie.gmit.ds.ValidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetValidation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.ValidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("GetValidation"))
              .build();
        }
      }
    }
    return getGetValidationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PasswordServiceStub newStub(io.grpc.Channel channel) {
    return new PasswordServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PasswordServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PasswordServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PasswordServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PasswordServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PasswordServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addHash(ie.gmit.ds.PasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getAddHashMethod(), responseObserver);
    }

    /**
     */
    public void getHash(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.PasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetHashMethod(), responseObserver);
    }

    /**
     */
    public void addValidation(ie.gmit.ds.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getAddValidationMethod(), responseObserver);
    }

    /**
     */
    public void getValidation(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.ValidateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetValidationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddHashMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.PasswordRequest,
                com.google.protobuf.BoolValue>(
                  this, METHODID_ADD_HASH)))
          .addMethod(
            getGetHashMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ie.gmit.ds.PasswordResponse>(
                  this, METHODID_GET_HASH)))
          .addMethod(
            getAddValidationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.ValidateRequest,
                com.google.protobuf.BoolValue>(
                  this, METHODID_ADD_VALIDATION)))
          .addMethod(
            getGetValidationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ie.gmit.ds.ValidateResponse>(
                  this, METHODID_GET_VALIDATION)))
          .build();
    }
  }

  /**
   */
  public static final class PasswordServiceStub extends io.grpc.stub.AbstractStub<PasswordServiceStub> {
    private PasswordServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceStub(channel, callOptions);
    }

    /**
     */
    public void addHash(ie.gmit.ds.PasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddHashMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHash(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.PasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetHashMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addValidation(ie.gmit.ds.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddValidationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getValidation(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.ValidateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetValidationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PasswordServiceBlockingStub extends io.grpc.stub.AbstractStub<PasswordServiceBlockingStub> {
    private PasswordServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.BoolValue addHash(ie.gmit.ds.PasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddHashMethod(), getCallOptions(), request);
    }

    /**
     */
    public ie.gmit.ds.PasswordResponse getHash(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetHashMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue addValidation(ie.gmit.ds.ValidateRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddValidationMethod(), getCallOptions(), request);
    }

    /**
     */
    public ie.gmit.ds.ValidateResponse getValidation(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetValidationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PasswordServiceFutureStub extends io.grpc.stub.AbstractStub<PasswordServiceFutureStub> {
    private PasswordServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> addHash(
        ie.gmit.ds.PasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddHashMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.PasswordResponse> getHash(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetHashMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> addValidation(
        ie.gmit.ds.ValidateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddValidationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.ValidateResponse> getValidation(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetValidationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_HASH = 0;
  private static final int METHODID_GET_HASH = 1;
  private static final int METHODID_ADD_VALIDATION = 2;
  private static final int METHODID_GET_VALIDATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PasswordServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PasswordServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_HASH:
          serviceImpl.addHash((ie.gmit.ds.PasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_GET_HASH:
          serviceImpl.getHash((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.PasswordResponse>) responseObserver);
          break;
        case METHODID_ADD_VALIDATION:
          serviceImpl.addValidation((ie.gmit.ds.ValidateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_GET_VALIDATION:
          serviceImpl.getValidation((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.ValidateResponse>) responseObserver);
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

  private static abstract class PasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PasswordServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.gmit.ds.Password.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PasswordService");
    }
  }

  private static final class PasswordServiceFileDescriptorSupplier
      extends PasswordServiceBaseDescriptorSupplier {
    PasswordServiceFileDescriptorSupplier() {}
  }

  private static final class PasswordServiceMethodDescriptorSupplier
      extends PasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PasswordServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PasswordServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PasswordServiceFileDescriptorSupplier())
              .addMethod(getAddHashMethod())
              .addMethod(getGetHashMethod())
              .addMethod(getAddValidationMethod())
              .addMethod(getGetValidationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
