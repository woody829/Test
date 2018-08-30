public class DummyClosable
        //implements Closeable

{
    /*
    private final boolean throwInClose;
    private final String name;

    public DummyClosable(boolean throwInConstruction, boolean throwInClose, String name) throws IOException {
        this.throwInClose = throwInClose;
        this.name = name;
        if (throwInConstruction) {
            throw new IOException("throwing in construction");
        }
    }

    @Override
    public void close() throws IOException {
        if (throwInClose) {
            throw new IOException("throwing in close");
        }
        System.out.println(name + " is closing...");
    }

    public static void main(String[] args) {
        try (DummyClosable d1 = new DummyClosable(false, false, "a");
             DummyClosable d2 = new DummyClosable(true, false, "b");) {
            throw new IOException("in main1");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("----end1----");

        try (DummyClosable d1 = new DummyClosable(false, false, "a");
             DummyClosable d2 = new DummyClosable(false, true, "b");) {
            throw new IOException("in main2");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("----end2----");
    }*/
}  