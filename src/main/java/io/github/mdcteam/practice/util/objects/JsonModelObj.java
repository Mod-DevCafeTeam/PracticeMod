package io.github.mdcteam.practice.util.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonModelObj {

    public TexturesObj textures;
    public ArrayList<ModelElementObj> elements;

    public static class ModelElementObj {
        public String name;
        public float[] from;
        public float[] to;

        public ElementFacesObj faces;

        private class ElementFacesObj {
            public ElementFaceObj north;
            public ElementFaceObj east;
            public ElementFaceObj south;
            public ElementFaceObj west;
            public ElementFaceObj up;
            public ElementFaceObj down;

            private class ElementFaceObj {
                public String texture;
                public float[] uv;
                public float rotation;
            }
        }
    }

    private class TexturesObj {

        @SerializedName("0")
        public String zero;
        @SerializedName("1")
        public String one;
        @SerializedName("2")
        public String two;
        @SerializedName("3")
        public String three;

        public String particle;
    }
}
