package domain.misc;

public class TestArugumentObjects {
    private static class ArrayWrapper {
        int[] x = null;

        public int[] getX() {
            return x;
        }

        public void setX(int[] x) {
            this.x = x;
        }
    }

    public static void modifyObject(ArrayWrapper arrayWrapper) {
        if (arrayWrapper.getX() == null) {
            arrayWrapper.setX(new int[10]);
        }

        for (int i = 0; i < arrayWrapper.getX().length; i++) {
            arrayWrapper.getX()[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("This program tests Objects as arguments in Java.");
        ArrayWrapper arrayWrapper = new ArrayWrapper();
        modifyObject(arrayWrapper);
        for (int i : arrayWrapper.getX()) {
            System.out.println(i);
        }
    }
}
