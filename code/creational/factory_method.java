// Product
interface Filter {
    void apply(String image);
}

// Concrete Products
class BlackAndWhiteFilter implements Filter {
    public void apply(String image) {
        System.out.println("Applying Black and White Filter to " + image);
    }
}

class SepiaFilter implements Filter {
    public void apply(String image) {
        System.out.println("Applying Sepia Filter to " + image);
    }
}

// Creator (Factory Method)
abstract class ImageProcessor {
    public void processImage(String image) {
        Filter filter = createFilter();
        filter.apply(image);
    }

    protected abstract Filter createFilter();
}

// Concrete Creators
class BlackAndWhiteImageProcessor extends ImageProcessor {
    protected Filter createFilter() {
        return new BlackAndWhiteFilter();
    }
}

class SepiaImageProcessor extends ImageProcessor {
    protected Filter createFilter() {
        return new SepiaFilter();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        ImageProcessor processor = new BlackAndWhiteImageProcessor();
        processor.processImage("image1.jpg");

        processor = new SepiaImageProcessor();
        processor.processImage("image2.jpg");
    }
}