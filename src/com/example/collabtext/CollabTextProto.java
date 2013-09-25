// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CollabText.proto

package com.example.collabtext;

public final class CollabTextProto {
  private CollabTextProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface globalMoveOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional bool delete = 1;
    /**
     * <code>optional bool delete = 1;</code>
     */
    boolean hasDelete();
    /**
     * <code>optional bool delete = 1;</code>
     */
    boolean getDelete();

    // required int32 location = 2;
    /**
     * <code>required int32 location = 2;</code>
     */
    boolean hasLocation();
    /**
     * <code>required int32 location = 2;</code>
     */
    int getLocation();

    // required int32 length = 3;
    /**
     * <code>required int32 length = 3;</code>
     */
    boolean hasLength();
    /**
     * <code>required int32 length = 3;</code>
     */
    int getLength();

    // required string text = 4;
    /**
     * <code>required string text = 4;</code>
     */
    boolean hasText();
    /**
     * <code>required string text = 4;</code>
     */
    java.lang.String getText();
    /**
     * <code>required string text = 4;</code>
     */
    com.google.protobuf.ByteString
        getTextBytes();
  }
  /**
   * Protobuf type {@code com.example.collabtext.globalMove}
   */
  public static final class globalMove extends
      com.google.protobuf.GeneratedMessage
      implements globalMoveOrBuilder {
    // Use globalMove.newBuilder() to construct.
    private globalMove(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private globalMove(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final globalMove defaultInstance;
    public static globalMove getDefaultInstance() {
      return defaultInstance;
    }

    public globalMove getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private globalMove(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              delete_ = input.readBool();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              location_ = input.readInt32();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              length_ = input.readInt32();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              text_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.collabtext.CollabTextProto.internal_static_com_example_collabtext_globalMove_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.collabtext.CollabTextProto.internal_static_com_example_collabtext_globalMove_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.collabtext.CollabTextProto.globalMove.class, com.example.collabtext.CollabTextProto.globalMove.Builder.class);
    }

    public static com.google.protobuf.Parser<globalMove> PARSER =
        new com.google.protobuf.AbstractParser<globalMove>() {
      public globalMove parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new globalMove(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<globalMove> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // optional bool delete = 1;
    public static final int DELETE_FIELD_NUMBER = 1;
    private boolean delete_;
    /**
     * <code>optional bool delete = 1;</code>
     */
    public boolean hasDelete() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional bool delete = 1;</code>
     */
    public boolean getDelete() {
      return delete_;
    }

    // required int32 location = 2;
    public static final int LOCATION_FIELD_NUMBER = 2;
    private int location_;
    /**
     * <code>required int32 location = 2;</code>
     */
    public boolean hasLocation() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int32 location = 2;</code>
     */
    public int getLocation() {
      return location_;
    }

    // required int32 length = 3;
    public static final int LENGTH_FIELD_NUMBER = 3;
    private int length_;
    /**
     * <code>required int32 length = 3;</code>
     */
    public boolean hasLength() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required int32 length = 3;</code>
     */
    public int getLength() {
      return length_;
    }

    // required string text = 4;
    public static final int TEXT_FIELD_NUMBER = 4;
    private java.lang.Object text_;
    /**
     * <code>required string text = 4;</code>
     */
    public boolean hasText() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required string text = 4;</code>
     */
    public java.lang.String getText() {
      java.lang.Object ref = text_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          text_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string text = 4;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      java.lang.Object ref = text_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        text_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      delete_ = false;
      location_ = 0;
      length_ = 0;
      text_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasLocation()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasLength()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasText()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBool(1, delete_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, location_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, length_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getTextBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(1, delete_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, location_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, length_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getTextBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.example.collabtext.CollabTextProto.globalMove parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.example.collabtext.CollabTextProto.globalMove prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.example.collabtext.globalMove}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.example.collabtext.CollabTextProto.globalMoveOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.example.collabtext.CollabTextProto.internal_static_com_example_collabtext_globalMove_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.example.collabtext.CollabTextProto.internal_static_com_example_collabtext_globalMove_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.example.collabtext.CollabTextProto.globalMove.class, com.example.collabtext.CollabTextProto.globalMove.Builder.class);
      }

      // Construct using com.example.collabtext.CollabTextProto.globalMove.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        delete_ = false;
        bitField0_ = (bitField0_ & ~0x00000001);
        location_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        length_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        text_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.example.collabtext.CollabTextProto.internal_static_com_example_collabtext_globalMove_descriptor;
      }

      public com.example.collabtext.CollabTextProto.globalMove getDefaultInstanceForType() {
        return com.example.collabtext.CollabTextProto.globalMove.getDefaultInstance();
      }

      public com.example.collabtext.CollabTextProto.globalMove build() {
        com.example.collabtext.CollabTextProto.globalMove result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.example.collabtext.CollabTextProto.globalMove buildPartial() {
        com.example.collabtext.CollabTextProto.globalMove result = new com.example.collabtext.CollabTextProto.globalMove(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.delete_ = delete_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.location_ = location_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.length_ = length_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.text_ = text_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.example.collabtext.CollabTextProto.globalMove) {
          return mergeFrom((com.example.collabtext.CollabTextProto.globalMove)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.example.collabtext.CollabTextProto.globalMove other) {
        if (other == com.example.collabtext.CollabTextProto.globalMove.getDefaultInstance()) return this;
        if (other.hasDelete()) {
          setDelete(other.getDelete());
        }
        if (other.hasLocation()) {
          setLocation(other.getLocation());
        }
        if (other.hasLength()) {
          setLength(other.getLength());
        }
        if (other.hasText()) {
          bitField0_ |= 0x00000008;
          text_ = other.text_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasLocation()) {
          
          return false;
        }
        if (!hasLength()) {
          
          return false;
        }
        if (!hasText()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.example.collabtext.CollabTextProto.globalMove parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.example.collabtext.CollabTextProto.globalMove) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional bool delete = 1;
      private boolean delete_ ;
      /**
       * <code>optional bool delete = 1;</code>
       */
      public boolean hasDelete() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional bool delete = 1;</code>
       */
      public boolean getDelete() {
        return delete_;
      }
      /**
       * <code>optional bool delete = 1;</code>
       */
      public Builder setDelete(boolean value) {
        bitField0_ |= 0x00000001;
        delete_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool delete = 1;</code>
       */
      public Builder clearDelete() {
        bitField0_ = (bitField0_ & ~0x00000001);
        delete_ = false;
        onChanged();
        return this;
      }

      // required int32 location = 2;
      private int location_ ;
      /**
       * <code>required int32 location = 2;</code>
       */
      public boolean hasLocation() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int32 location = 2;</code>
       */
      public int getLocation() {
        return location_;
      }
      /**
       * <code>required int32 location = 2;</code>
       */
      public Builder setLocation(int value) {
        bitField0_ |= 0x00000002;
        location_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 location = 2;</code>
       */
      public Builder clearLocation() {
        bitField0_ = (bitField0_ & ~0x00000002);
        location_ = 0;
        onChanged();
        return this;
      }

      // required int32 length = 3;
      private int length_ ;
      /**
       * <code>required int32 length = 3;</code>
       */
      public boolean hasLength() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required int32 length = 3;</code>
       */
      public int getLength() {
        return length_;
      }
      /**
       * <code>required int32 length = 3;</code>
       */
      public Builder setLength(int value) {
        bitField0_ |= 0x00000004;
        length_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 length = 3;</code>
       */
      public Builder clearLength() {
        bitField0_ = (bitField0_ & ~0x00000004);
        length_ = 0;
        onChanged();
        return this;
      }

      // required string text = 4;
      private java.lang.Object text_ = "";
      /**
       * <code>required string text = 4;</code>
       */
      public boolean hasText() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required string text = 4;</code>
       */
      public java.lang.String getText() {
        java.lang.Object ref = text_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          text_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string text = 4;</code>
       */
      public com.google.protobuf.ByteString
          getTextBytes() {
        java.lang.Object ref = text_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          text_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string text = 4;</code>
       */
      public Builder setText(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        text_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string text = 4;</code>
       */
      public Builder clearText() {
        bitField0_ = (bitField0_ & ~0x00000008);
        text_ = getDefaultInstance().getText();
        onChanged();
        return this;
      }
      /**
       * <code>required string text = 4;</code>
       */
      public Builder setTextBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        text_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.example.collabtext.globalMove)
    }

    static {
      defaultInstance = new globalMove(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.example.collabtext.globalMove)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_collabtext_globalMove_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_example_collabtext_globalMove_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020CollabText.proto\022\026com.example.collabte" +
      "xt\"L\n\nglobalMove\022\016\n\006delete\030\001 \001(\010\022\020\n\010loca" +
      "tion\030\002 \002(\005\022\016\n\006length\030\003 \002(\005\022\014\n\004text\030\004 \002(\t" +
      "B\021B\017CollabTextProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_example_collabtext_globalMove_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_example_collabtext_globalMove_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_example_collabtext_globalMove_descriptor,
              new java.lang.String[] { "Delete", "Location", "Length", "Text", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}