package com.nukkitx.protocol.bedrock.v361.serializer;

import com.nukkitx.protocol.bedrock.packet.ScriptCustomEventPacket;
import com.nukkitx.protocol.bedrock.v361.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScriptCustomEventSerializer_v361 implements PacketSerializer<ScriptCustomEventPacket> {
    public static final ScriptCustomEventSerializer_v361 INSTANCE = new ScriptCustomEventSerializer_v361();


    @Override
    public void serialize(ByteBuf buffer, ScriptCustomEventPacket packet) {
        BedrockUtils.writeString(buffer, packet.getEventName());
        BedrockUtils.writeString(buffer, packet.getData());
    }

    @Override
    public void deserialize(ByteBuf buffer, ScriptCustomEventPacket packet) {
        packet.setEventName(BedrockUtils.readString(buffer));
        packet.setData(BedrockUtils.readString(buffer));
    }
}

