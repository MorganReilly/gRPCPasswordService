// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public final class Password {
  private Password() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_PasswordRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_PasswordRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_PasswordResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_PasswordResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_ValidateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_ValidateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_ValidateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_ValidateResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016password.proto\022\nie.gmit.ds\032\036google/pro" +
      "tobuf/wrappers.proto\032\033google/protobuf/em" +
      "pty.proto\"3\n\017PasswordRequest\022\016\n\006userId\030\001" +
      " \001(\005\022\020\n\010password\030\002 \001(\t\"H\n\020PasswordRespon" +
      "se\022\016\n\006userId\030\001 \001(\005\022\026\n\016hashedPassword\030\002 \001" +
      "(\t\022\014\n\004salt\030\003 \001(\t\"1\n\017ValidateRequest\022\020\n\010p" +
      "assword\030\001 \001(\t\022\014\n\004salt\030\002 \001(\t\")\n\020ValidateR" +
      "esponse\022\025\n\rvalidPassword\030\001 \001(\0102\247\002\n\017Passw" +
      "ordService\022B\n\007AddHash\022\033.ie.gmit.ds.Passw" +
      "ordRequest\032\032.google.protobuf.BoolValue\022?" +
      "\n\007GetHash\022\026.google.protobuf.Empty\032\034.ie.g" +
      "mit.ds.PasswordResponse\022H\n\rAddValidation" +
      "\022\033.ie.gmit.ds.ValidateRequest\032\032.google.p" +
      "rotobuf.BoolValue\022E\n\rGetValidation\022\026.goo" +
      "gle.protobuf.Empty\032\034.ie.gmit.ds.Validate" +
      "ResponseB\016\n\nie.gmit.dsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_ie_gmit_ds_PasswordRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ie_gmit_ds_PasswordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_PasswordRequest_descriptor,
        new java.lang.String[] { "UserId", "Password", });
    internal_static_ie_gmit_ds_PasswordResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ie_gmit_ds_PasswordResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_PasswordResponse_descriptor,
        new java.lang.String[] { "UserId", "HashedPassword", "Salt", });
    internal_static_ie_gmit_ds_ValidateRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ie_gmit_ds_ValidateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_ValidateRequest_descriptor,
        new java.lang.String[] { "Password", "Salt", });
    internal_static_ie_gmit_ds_ValidateResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ie_gmit_ds_ValidateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_ValidateResponse_descriptor,
        new java.lang.String[] { "ValidPassword", });
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
