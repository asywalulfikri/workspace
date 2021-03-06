package gosip.artis.indonesia;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by asywalulfikri on 1/13/17.
 */

public class GLHelpers {
    public static FloatBuffer floatBuffer(int size) {
        ByteBuffer bb = ByteBuffer.allocateDirect(size * 4);
        bb.order(ByteOrder.nativeOrder());
        return bb.asFloatBuffer();
    }

    public static ShortBuffer shortBuffer(int size) {
        ByteBuffer bb = ByteBuffer.allocateDirect(size * 2);
        bb.order(ByteOrder.nativeOrder());
        return bb.asShortBuffer();
    }
}