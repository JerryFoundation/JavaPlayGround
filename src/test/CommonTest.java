package test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author zhuqianchao
 * @date 2019-04-22 15:23
 */
public class CommonTest {
    class Spiter extends LengthFieldBasedFrameDecoder {
        // 数据偏移量
        private static final int LENGTH_FIELD_OFFSET = 7;
        // 数据长度
        private static final int LENGTH_FIELD_LENGTH = 4;

        /**
         * Creates a new instance.
         *
         * @param maxFrameLength    the maximum length of the frame.  If the length of the frame is
         *                          greater than this value, {@link TooLongFrameException} will be
         *                          thrown.
         * @param lengthFieldOffset the offset of the length field
         * @param lengthFieldLength
         */
        public Spiter(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
            super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
        }


        /**
         * Create a frame out of the {@link ByteBuf} and return it.
         *
         * @param ctx the {@link ChannelHandlerContext} which this {@link ByteToMessageDecoder} belongs to
         * @param in  the {@link ByteBuf} from which to read data
         * @return frame           the {@link ByteBuf} which represent the frame or {@code null} if no frame could
         * be created.
         */
        @Override
        protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
            // 屏蔽非本协议的客户端
            if (in.getInt(in.readerIndex()) != 0x12345678) {
                ctx.channel().close();
                return null;
            }

            return super.decode(ctx, in);
        }
    }
}
