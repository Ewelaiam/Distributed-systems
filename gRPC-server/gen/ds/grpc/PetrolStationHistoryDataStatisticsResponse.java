// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/petrol_station_history_data.proto

package ds.grpc;

/**
 * Protobuf type {@code petrolStationHistoryData.PetrolStationHistoryDataStatisticsResponse}
 */
public final class PetrolStationHistoryDataStatisticsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:petrolStationHistoryData.PetrolStationHistoryDataStatisticsResponse)
    PetrolStationHistoryDataStatisticsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PetrolStationHistoryDataStatisticsResponse.newBuilder() to construct.
  private PetrolStationHistoryDataStatisticsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PetrolStationHistoryDataStatisticsResponse() {
    stats_ = emptyDoubleList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PetrolStationHistoryDataStatisticsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PetrolStationHistoryDataStatisticsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 9: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              stats_ = newDoubleList();
              mutable_bitField0_ |= 0x00000001;
            }
            stats_.addDouble(input.readDouble());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              stats_ = newDoubleList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              stats_.addDouble(input.readDouble());
            }
            input.popLimit(limit);
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        stats_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.grpc.PetrolStationHistoryDataProto.internal_static_petrolStationHistoryData_PetrolStationHistoryDataStatisticsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.grpc.PetrolStationHistoryDataProto.internal_static_petrolStationHistoryData_PetrolStationHistoryDataStatisticsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.grpc.PetrolStationHistoryDataStatisticsResponse.class, ds.grpc.PetrolStationHistoryDataStatisticsResponse.Builder.class);
  }

  public static final int STATS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.DoubleList stats_;
  /**
   * <code>repeated double stats = 1;</code>
   * @return A list containing the stats.
   */
  @java.lang.Override
  public java.util.List<java.lang.Double>
      getStatsList() {
    return stats_;
  }
  /**
   * <code>repeated double stats = 1;</code>
   * @return The count of stats.
   */
  public int getStatsCount() {
    return stats_.size();
  }
  /**
   * <code>repeated double stats = 1;</code>
   * @param index The index of the element to return.
   * @return The stats at the given index.
   */
  public double getStats(int index) {
    return stats_.getDouble(index);
  }
  private int statsMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (getStatsList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(statsMemoizedSerializedSize);
    }
    for (int i = 0; i < stats_.size(); i++) {
      output.writeDoubleNoTag(stats_.getDouble(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      dataSize = 8 * getStatsList().size();
      size += dataSize;
      if (!getStatsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      statsMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof ds.grpc.PetrolStationHistoryDataStatisticsResponse)) {
      return super.equals(obj);
    }
    ds.grpc.PetrolStationHistoryDataStatisticsResponse other = (ds.grpc.PetrolStationHistoryDataStatisticsResponse) obj;

    if (!getStatsList()
        .equals(other.getStatsList())) return false;
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
    if (getStatsCount() > 0) {
      hash = (37 * hash) + STATS_FIELD_NUMBER;
      hash = (53 * hash) + getStatsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse parseFrom(
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
  public static Builder newBuilder(ds.grpc.PetrolStationHistoryDataStatisticsResponse prototype) {
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
   * Protobuf type {@code petrolStationHistoryData.PetrolStationHistoryDataStatisticsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:petrolStationHistoryData.PetrolStationHistoryDataStatisticsResponse)
      ds.grpc.PetrolStationHistoryDataStatisticsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.grpc.PetrolStationHistoryDataProto.internal_static_petrolStationHistoryData_PetrolStationHistoryDataStatisticsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.grpc.PetrolStationHistoryDataProto.internal_static_petrolStationHistoryData_PetrolStationHistoryDataStatisticsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.grpc.PetrolStationHistoryDataStatisticsResponse.class, ds.grpc.PetrolStationHistoryDataStatisticsResponse.Builder.class);
    }

    // Construct using ds.grpc.PetrolStationHistoryDataStatisticsResponse.newBuilder()
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
      stats_ = emptyDoubleList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.grpc.PetrolStationHistoryDataProto.internal_static_petrolStationHistoryData_PetrolStationHistoryDataStatisticsResponse_descriptor;
    }

    @java.lang.Override
    public ds.grpc.PetrolStationHistoryDataStatisticsResponse getDefaultInstanceForType() {
      return ds.grpc.PetrolStationHistoryDataStatisticsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.grpc.PetrolStationHistoryDataStatisticsResponse build() {
      ds.grpc.PetrolStationHistoryDataStatisticsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.grpc.PetrolStationHistoryDataStatisticsResponse buildPartial() {
      ds.grpc.PetrolStationHistoryDataStatisticsResponse result = new ds.grpc.PetrolStationHistoryDataStatisticsResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        stats_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.stats_ = stats_;
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
      if (other instanceof ds.grpc.PetrolStationHistoryDataStatisticsResponse) {
        return mergeFrom((ds.grpc.PetrolStationHistoryDataStatisticsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.grpc.PetrolStationHistoryDataStatisticsResponse other) {
      if (other == ds.grpc.PetrolStationHistoryDataStatisticsResponse.getDefaultInstance()) return this;
      if (!other.stats_.isEmpty()) {
        if (stats_.isEmpty()) {
          stats_ = other.stats_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureStatsIsMutable();
          stats_.addAll(other.stats_);
        }
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
      ds.grpc.PetrolStationHistoryDataStatisticsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.grpc.PetrolStationHistoryDataStatisticsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.Internal.DoubleList stats_ = emptyDoubleList();
    private void ensureStatsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        stats_ = mutableCopy(stats_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @return A list containing the stats.
     */
    public java.util.List<java.lang.Double>
        getStatsList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(stats_) : stats_;
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @return The count of stats.
     */
    public int getStatsCount() {
      return stats_.size();
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @param index The index of the element to return.
     * @return The stats at the given index.
     */
    public double getStats(int index) {
      return stats_.getDouble(index);
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @param index The index to set the value at.
     * @param value The stats to set.
     * @return This builder for chaining.
     */
    public Builder setStats(
        int index, double value) {
      ensureStatsIsMutable();
      stats_.setDouble(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @param value The stats to add.
     * @return This builder for chaining.
     */
    public Builder addStats(double value) {
      ensureStatsIsMutable();
      stats_.addDouble(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @param values The stats to add.
     * @return This builder for chaining.
     */
    public Builder addAllStats(
        java.lang.Iterable<? extends java.lang.Double> values) {
      ensureStatsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, stats_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated double stats = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStats() {
      stats_ = emptyDoubleList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:petrolStationHistoryData.PetrolStationHistoryDataStatisticsResponse)
  }

  // @@protoc_insertion_point(class_scope:petrolStationHistoryData.PetrolStationHistoryDataStatisticsResponse)
  private static final ds.grpc.PetrolStationHistoryDataStatisticsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.grpc.PetrolStationHistoryDataStatisticsResponse();
  }

  public static ds.grpc.PetrolStationHistoryDataStatisticsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PetrolStationHistoryDataStatisticsResponse>
      PARSER = new com.google.protobuf.AbstractParser<PetrolStationHistoryDataStatisticsResponse>() {
    @java.lang.Override
    public PetrolStationHistoryDataStatisticsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PetrolStationHistoryDataStatisticsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PetrolStationHistoryDataStatisticsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PetrolStationHistoryDataStatisticsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.grpc.PetrolStationHistoryDataStatisticsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

