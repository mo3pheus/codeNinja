package domain.misc;

public class JSONParser {
    static class JsonNode {
        String   key   = null;
        String   value = null;
        JsonNode child = null;

        // k1.k2.k3.k4:v1
        public JsonNode(String content) {
            String[] key_val = content.split(":");
            String   temp    = key_val[0];
            System.out.println(temp);
            String[] children = temp.split("\\.");
            if (children.length > 1) {
                key = getFragment(key_val[0], true);
                child = new JsonNode(getFragment(content, false));
            } else {
                key = key_val[0];
                value = key_val[1];
            }
        }

        String getFragment(String temp, boolean parent) {
            String[] fragments      = temp.split("\\.");
            String   returnFragment = (parent) ? fragments[0] : temp.substring(fragments[0].length()+1, temp.length());
            return returnFragment;
        }

        @Override
        public String toString() {
            if (child != null) {
                return "{" + key + ":" + child.toString() + "}";
            } else {
                return "{" + key + ":" + value + "}";
            }

            /*
             * {
             *   k1:{
             *       k2:{
             *           k3:{
             *              k4:v2
             *           }
             *       }
             *   }
             * }
             *
             * */
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to JSon parsing.");
        JsonNode node = new JsonNode("k1.k2.k3.k4.k5:v1");
        System.out.println(node.toString());
    }
}
