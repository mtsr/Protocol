package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.BedrockPacketType;
import com.nukkitx.protocol.bedrock.data.inventory.stackrequestactions.StackRequestActionData;
import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class ItemStackRequestPacket extends BedrockPacket {
    private final List<Request> requests = new ArrayList<>();

    @Override
    public boolean handle(BedrockPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public BedrockPacketType getPacketType() {
        return BedrockPacketType.ITEM_STACK_REQUEST;
    }

    /**
     * Request represents a single request present in an ItemStackRequest packet sent by the client to
     * change an item in an inventory.
     * Item stack requests are either approved or rejected by the server using the ItemStackResponse packet.
     */
    @Getter
    @AllArgsConstructor
    public static class Request {
        // requestId is a unique ID for the request. This ID is used by the server to send a response for this
        // specific request in the ItemStackResponse packet.
        int requestId;

        // actions is a list of actions performed by the client. The actual type of the actions depends on which
        // ID was present
        StackRequestActionData[] actions;
    }

}
