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
      com.google.protobuf.BoolValue> getAddPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addPassword",
      requestType = ie.gmit.ds.PasswordRequest.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.PasswordRequest,
      com.google.protobuf.BoolValue> getAddPasswordMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.PasswordRequest, com.google.protobuf.BoolValue> getAddPasswordMethod;
    if ((getAddPasswordMethod = PasswordServiceGrpc.getAddPasswordMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getAddPasswordMethod = PasswordServiceGrpc.getAddPasswordMethod) == null) {
          PasswordServiceGrpc.getAddPasswordMethod = getAddPasswordMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.PasswordRequest, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.PasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("addPassword"))
              .build();
        }
      }
    }
    return getAddPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.PasswordResponse> getGetPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPassword",
      requestType = com.google.protobuf.Empty.class,
      responseType = ie.gmit.ds.PasswordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.PasswordResponse> getGetPasswordMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ie.gmit.ds.PasswordResponse> getGetPasswordMethod;
    if ((getGetPasswordMethod = PasswordServiceGrpc.getGetPasswordMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getGetPasswordMethod = PasswordServiceGrpc.getGetPasswordMethod) == null) {
          PasswordServiceGrpc.getGetPasswordMethod = getGetPasswordMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ie.gmit.ds.PasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.PasswordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("getPassword"))
              .build();
        }
      }
    }
    return getGetPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.PasswordResponse,
      com.google.protobuf.BoolValue> getAddPasswordValidationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addPasswordValidation",
      requestType = ie.gmit.ds.PasswordResponse.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.PasswordResponse,
      com.google.protobuf.BoolValue> getAddPasswordValidationMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.PasswordResponse, com.google.protobuf.BoolValue> getAddPasswordValidationMethod;
    if ((getAddPasswordValidationMethod = PasswordServiceGrpc.getAddPasswordValidationMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getAddPasswordValidationMethod = PasswordServiceGrpc.getAddPasswordValidationMethod) == null) {
          PasswordServiceGrpc.getAddPasswordValidationMethod = getAddPasswordValidationMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.PasswordResponse, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addPasswordValidation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.PasswordResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("addPasswordValidation"))
              .build();
        }
      }
    }
    return getAddPasswordValidationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.ValidateResponse> getGetPasswordValidationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPasswordValidation",
      requestType = com.google.protobuf.Empty.class,
      responseType = ie.gmit.ds.ValidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ie.gmit.ds.ValidateResponse> getGetPasswordValidationMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ie.gmit.ds.ValidateResponse> getGetPasswordValidationMethod;
    if ((getGetPasswordValidationMethod = PasswordServiceGrpc.getGetPasswordValidationMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getGetPasswordValidationMethod = PasswordServiceGrpc.getGetPasswordValidationMethod) == null) {
          PasswordServiceGrpc.getGetPasswordValidationMethod = getGetPasswordValidationMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ie.gmit.ds.ValidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPasswordValidation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.ValidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("getPasswordValidation"))
              .build();
        }
      }
    }
    return getGetPasswordValidationMethod;
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
     * <pre>
     * Req, res, req, res.
     * </pre>
     */
    public void addPassword(ie.gmit.ds.PasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPasswordMethod(), responseObserver);
    }

    /**
     */
    public void getPassword(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.PasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPasswordMethod(), responseObserver);
    }

    /**
     */
    public void addPasswordValidation(ie.gmit.ds.PasswordResponse request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPasswordValidationMethod(), responseObserver);
    }

    /**
     */
    public void getPasswordValidation(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.ValidateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPasswordValidationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddPasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.PasswordRequest,
                com.google.protobuf.BoolValue>(
                  this, METHODID_ADD_PASSWORD)))
          .addMethod(
            getGetPasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ie.gmit.ds.PasswordResponse>(
                  this, METHODID_GET_PASSWORD)))
          .addMethod(
            getAddPasswordValidationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.PasswordResponse,
                com.google.protobuf.BoolValue>(
                  this, METHODID_ADD_PASSWORD_VALIDATION)))
          .addMethod(
            getGetPasswordValidationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ie.gmit.ds.ValidateResponse>(
                  this, METHODID_GET_PASSWORD_VALIDATION)))
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
     * <pre>
     * Req, res, req, res.
     * </pre>
     */
    public void addPassword(ie.gmit.ds.PasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPassword(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.PasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPasswordValidation(ie.gmit.ds.PasswordResponse request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPasswordValidationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPasswordValidation(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.ValidateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPasswordValidationMethod(), getCallOptions()), request, responseObserver);
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
     * <pre>
     * Req, res, req, res.
     * </pre>
     */
    public com.google.protobuf.BoolValue addPassword(ie.gmit.ds.PasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public ie.gmit.ds.PasswordResponse getPassword(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue addPasswordValidation(ie.gmit.ds.PasswordResponse request) {
      return blockingUnaryCall(
          getChannel(), getAddPasswordValidationMethod(), getCallOptions(), request);
    }

    /**
     */
    public ie.gmit.ds.ValidateResponse getPasswordValidation(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetPasswordValidationMethod(), getCallOptions(), request);
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
     * <pre>
     * Req, res, req, res.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> addPassword(
        ie.gmit.ds.PasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.PasswordResponse> getPassword(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> addPasswordValidation(
        ie.gmit.ds.PasswordResponse request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPasswordValidationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.ValidateResponse> getPasswordValidation(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPasswordValidationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PASSWORD = 0;
  private static final int METHODID_GET_PASSWORD = 1;
  private static final int METHODID_ADD_PASSWORD_VALIDATION = 2;
  private static final int METHODID_GET_PASSWORD_VALIDATION = 3;

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
        case METHODID_ADD_PASSWORD:
          serviceImpl.addPassword((ie.gmit.ds.PasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_GET_PASSWORD:
          serviceImpl.getPassword((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.PasswordResponse>) responseObserver);
          break;
        case METHODID_ADD_PASSWORD_VALIDATION:
          serviceImpl.addPasswordValidation((ie.gmit.ds.PasswordResponse) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_GET_PASSWORD_VALIDATION:
          serviceImpl.getPasswordValidation((com.google.protobuf.Empty) request,
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
              .addMethod(getAddPasswordMethod())
              .addMethod(getGetPasswordMethod())
              .addMethod(getAddPasswordValidationMethod())
              .addMethod(getGetPasswordValidationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
