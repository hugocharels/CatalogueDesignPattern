// Subject Interface
interface FileDownloader {
    void download(String fileUrl);
}

// Real Subject
class RealFileDownloader implements FileDownloader {
    @Override
    public void download(String fileUrl) {
        System.out.println("Downloading file from: " + fileUrl);
    }
}

// Proxy
class FileDownloaderProxy implements FileDownloader {
    private boolean isAdmin;

    public FileDownloaderProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void download(String fileUrl) {
        if (isAdmin) {
            RealFileDownloader realFileDownloader = new RealFileDownloader();
            realFileDownloader.download(fileUrl);
        } else {
            System.out.println("Access denied. Only admins can download files.");
        }
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        FileDownloaderProxy fileDownloader = new FileDownloaderProxy(true);
        fileDownloader.download("https://example.com/sample.pdf");

        FileDownloaderProxy restrictedDownloader = new FileDownloaderProxy(false);
        restrictedDownloader.download("https://example.com/secret.pdf");
    }
}