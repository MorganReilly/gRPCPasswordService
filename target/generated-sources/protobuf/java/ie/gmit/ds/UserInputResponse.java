// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

/**
 * <pre>
 * Hash Password - Response
 * </pre>
 *
 * Protobuf type {@code ie.gmit.ds.UserInputResponse}
 */
public  final class UserInputResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ie.gmit.ds.UserInputResponse)
    UserInputResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserInputResponse.newBuilder() to construct.
  private UserInputResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserInputResponse() {
    expectedHash_ = "";
    salt_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UserInputResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserInputResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            userId_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            expectedHash_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            salt_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ie.gmit.ds.Password.internal_static_ie_gmit_ds_UserInputResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.gmit.ds.Password.internal_static_ie_gmit_ds_UserInputResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.gmit.ds.UserInputResponse.class, ie.gmit.ds.UserInputResponse.Builder.class);
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private int userId_;
  /**
   * <code>int32 userId = 1;</code>
   */
  public int getUserId() {
    return userId_;
  }

  public static final int EXPECTEDHASH_FIELD_NUMBER = 2;
  private volatile java.lang.Object expectedHash_;
  /**
   * <code>string expectedHash = 2;</code>
   */
  public java.lang.String getExpectedHash() {
    java.lang.Object ref = expectedHash_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      expectedHash_ = s;
      return s;
    }
  }
  /**
   * <code>string expectedHash = 2;</code>
   */
  public com.google.protobuf.ByteString
      getExpectedHashBytes() {
    java.lang.Object ref = expectedHash_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      expectedHash_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SALT_FIELD_NUMBER = 3;
  private volatile java.lang.Object salt_;
  /**
   * <code>string salt = 3;</code>
   */
  public java.lang.String getSalt() {
    java.lang.Object ref = salt_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      salt_ = s;
      return s;
    }
  }
  /**
   * <code>string salt = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSaltBytes() {
    java.lang.Object ref = salt_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      salt_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!getExpectedHashBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, expectedHash_);
    }
    if (!getSaltBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, salt_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, userId_);
    }
    if (!getExpectedHashBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, expectedHash_);
    }
    if (!getSaltBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, salt_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ie.gmit.ds.UserInputResponse)) {
      return super.equals(obj);
    }
    ie.gmit.ds.UserInputResponse other = (ie.gmit.ds.UserInputResponse) obj;

    if (getUserId()
        != other.getUserId()) return false;
    if (!getExpectedHash()
        .equals(other.getExpectedHash())) return false;
    if (!getSalt()
        .equals(other.getSalt())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId();
    hash = (37 * hash) + EXPECTEDHASH_FIELD_NUMBER;
    hash = (53 * hash) + getExpectedHash().hashCode();
    hash = (37 * hash) + SALT_FIELD_NUMBER;
    hash = (53 * hash) + getSalt().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.gmit.ds.UserInputResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.gmit.ds.UserInputResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.UserInputResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.UserInputResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ie.gmit.ds.UserInputResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Hash Password - Response
   * </pre>
   *
   * Protobuf type {@code ie.gmit.ds.UserInputResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ie.gmit.ds.UserInputResponse)
      ie.gmit.ds.UserInputResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.gmit.ds.Password.internal_static_ie_gmit_ds_UserInputResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.gmit.ds.Password.internal_static_ie_gmit_ds_UserInputResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.gmit.ds.UserInputResponse.class, ie.gmit.ds.UserInputResponse.Builder.class);
    }

    // Construct using ie.gmit.ds.UserInputResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      userId_ = 0;

      expectedHash_ = "";

      salt_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.gmit.ds.Password.internal_static_ie_gmit_ds_UserInputResponse_descriptor;
    }

    @java.lang.Override
    public ie.gmit.ds.UserInputResponse getDefaultInstanceForType() {
      return ie.gmit.ds.UserInputResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ie.gmit.ds.UserInputResponse build() {
      ie.gmit.ds.UserInputResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.gmit.ds.UserInputResponse buildPartial() {
      ie.gmit.ds.UserInputResponse result = new ie.gmit.ds.UserInputResponse(this);
      result.userId_ = userId_;
      result.expectedHash_ = expectedHash_;
      result.salt_ = salt_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ie.gmit.ds.UserInputResponse) {
        return mergeFrom((ie.gmit.ds.UserInputResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.gmit.ds.UserInputResponse other) {
      if (other == ie.gmit.ds.UserInputResponse.getDefaultInstance()) return this;
      if (other.getUserId() != 0) {
        setUserId(other.getUserId());
      }
      if (!other.getExpectedHash().isEmpty()) {
        expectedHash_ = other.expectedHash_;
        onChanged();
      }
      if (!other.getSalt().isEmpty()) {
        salt_ = other.salt_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ie.gmit.ds.UserInputResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.gmit.ds.UserInputResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int userId_ ;
    /**
     * <code>int32 userId = 1;</code>
     */
    public int getUserId() {
      return userId_;
    }
    /**
     * <code>int32 userId = 1;</code>
     */
    public Builder setUserId(int value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 userId = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object expectedHash_ = "";
    /**
     * <code>string expectedHash = 2;</code>
     */
    public java.lang.String getExpectedHash() {
      java.lang.Object ref = expectedHash_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        expectedHash_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string expectedHash = 2;</code>
     */
    public com.google.protobuf.ByteString
        getExpectedHashBytes() {
      java.lang.Object ref = expectedHash_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        expectedHash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string expectedHash = 2;</code>
     */
    public Builder setExpectedHash(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      expectedHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string expectedHash = 2;</code>
     */
    public Builder clearExpectedHash() {
      
      expectedHash_ = getDefaultInstance().getExpectedHash();
      onChanged();
      return this;
    }
    /**
     * <code>string expectedHash = 2;</code>
     */
    public Builder setExpectedHashBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      expectedHash_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object salt_ = "";
    /**
     * <code>string salt = 3;</code>
     */
    public java.lang.String getSalt() {
      java.lang.Object ref = salt_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        salt_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string salt = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSaltBytes() {
      java.lang.Object ref = salt_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        salt_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string salt = 3;</code>
     */
    public Builder setSalt(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      salt_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string salt = 3;</code>
     */
    public Builder clearSalt() {
      
      salt_ = getDefaultInstance().getSalt();
      onChanged();
      return this;
    }
    /**
     * <code>string salt = 3;</code>
     */
    public Builder setSaltBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      salt_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ie.gmit.ds.UserInputResponse)
  }

  // @@protoc_insertion_point(class_scope:ie.gmit.ds.UserInputResponse)
  private static final ie.gmit.ds.UserInputResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.gmit.ds.UserInputResponse();
  }

  public static ie.gmit.ds.UserInputResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserInputResponse>
      PARSER = new com.google.protobuf.AbstractParser<UserInputResponse>() {
    @java.lang.Override
    public UserInputResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserInputResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserInputResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserInputResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.gmit.ds.UserInputResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
