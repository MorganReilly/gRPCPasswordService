// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public interface UserInputResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.UserInputResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   */
  int getUserId();

  /**
   * <code>string expectedHash = 2;</code>
   */
  java.lang.String getExpectedHash();
  /**
   * <code>string expectedHash = 2;</code>
   */
  com.google.protobuf.ByteString
      getExpectedHashBytes();

  /**
   * <code>string salt = 3;</code>
   */
  java.lang.String getSalt();
  /**
   * <code>string salt = 3;</code>
   */
  com.google.protobuf.ByteString
      getSaltBytes();
}