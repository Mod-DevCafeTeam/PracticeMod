package io.github.mdcteam.practice.util.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonModelObj {

    public HashMap<String, String> textures;
    public ArrayList<ModelElementObj> elements;

    public static class ModelElementObj {
        public String name;
        public float[] from;
        public float[] to;

        public HashMap<String, ElementFaceObj> faces;

        public class ElementFaceObj {
            public String texture;
            public float[] uv;
            public float rotation = 0;
        }
    }

}
