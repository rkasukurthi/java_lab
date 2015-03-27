package git;

import java.io.File;
import java.io.IOException;

import org.apache.ivy.plugins.repository.Repository;

public class CreateNewRepository {
    public static void main(String[] args) throws IOException {
        // prepare a new folder
        File localPath = File.createTempFile("TestGitRepository", "");
        localPath.delete();

        // create the directory
        Repository repository = FileRepositoryBuilder.create(new File(localPath, ".git"));
        repository.create();

        System.out.println("Having repository: " + repository.getDirectory());

        repository.close();

        FileUtils.deleteDirectory(localPath);
    }
}
