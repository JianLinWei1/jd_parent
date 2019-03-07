// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: client/client.message.proto

package com.ljzn.grpc.client;

public interface ClientMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:JdSystem.ClientMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *设备序列号       必填
   * </pre>
   *
   * <code>string deviceSeril = 1;</code>
   */
  java.lang.String getDeviceSeril();
  /**
   * <pre>
   *设备序列号       必填
   * </pre>
   *
   * <code>string deviceSeril = 1;</code>
   */
  com.google.protobuf.ByteString
      getDeviceSerilBytes();

  /**
   * <pre>
   *设备名称            必填
   * </pre>
   *
   * <code>string deviceName = 2;</code>
   */
  java.lang.String getDeviceName();
  /**
   * <pre>
   *设备名称            必填
   * </pre>
   *
   * <code>string deviceName = 2;</code>
   */
  com.google.protobuf.ByteString
      getDeviceNameBytes();

  /**
   * <pre>
   *设备类型      ( 1 大门闸机 2考勤机 3 访客机 4 人证机)
   * </pre>
   *
   * <code>int32 deviceType = 3;</code>
   */
  int getDeviceType();

  /**
   * <pre>
   *设备地址   非必填
   * </pre>
   *
   * <code>string deviceAddress = 4;</code>
   */
  java.lang.String getDeviceAddress();
  /**
   * <pre>
   *设备地址   非必填
   * </pre>
   *
   * <code>string deviceAddress = 4;</code>
   */
  com.google.protobuf.ByteString
      getDeviceAddressBytes();

  /**
   * <pre>
   * 经纬度  非必填  格式{"longitude":"XXxx","latitude":"XXxx"}
   * </pre>
   *
   * <code>string deviceAccuracy = 5;</code>
   */
  java.lang.String getDeviceAccuracy();
  /**
   * <pre>
   * 经纬度  非必填  格式{"longitude":"XXxx","latitude":"XXxx"}
   * </pre>
   *
   * <code>string deviceAccuracy = 5;</code>
   */
  com.google.protobuf.ByteString
      getDeviceAccuracyBytes();

  /**
   * <pre>
   * 所属服务账号名  必填
   * </pre>
   *
   * <code>string serviceAccount = 6;</code>
   */
  java.lang.String getServiceAccount();
  /**
   * <pre>
   * 所属服务账号名  必填
   * </pre>
   *
   * <code>string serviceAccount = 6;</code>
   */
  com.google.protobuf.ByteString
      getServiceAccountBytes();

  /**
   * <pre>
   *所属服务密码 必填
   * </pre>
   *
   * <code>string servicePassword = 7;</code>
   */
  java.lang.String getServicePassword();
  /**
   * <pre>
   *所属服务密码 必填
   * </pre>
   *
   * <code>string servicePassword = 7;</code>
   */
  com.google.protobuf.ByteString
      getServicePasswordBytes();

  /**
   * <pre>
   *客户端ip
   * </pre>
   *
   * <code>string client_ip = 8;</code>
   */
  java.lang.String getClientIp();
  /**
   * <pre>
   *客户端ip
   * </pre>
   *
   * <code>string client_ip = 8;</code>
   */
  com.google.protobuf.ByteString
      getClientIpBytes();

  /**
   * <pre>
   *客户端grpc端口
   * </pre>
   *
   * <code>int32 client_port = 9;</code>
   */
  int getClientPort();
}
