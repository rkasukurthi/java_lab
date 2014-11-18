package sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class SoundRecgonizer {

  public static void main(String[] args) throws IOException {
    Configuration configuration = new Configuration();

    // Set path to acoustic model.
    configuration.setAcousticModelPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz");
    // Set path to dictionary.
    configuration
        .setDictionaryPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz/dict/cmudict.0.6d");
    // Set language model.
    configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/language/en-us.lm.dmp");

    
    StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
    recognizer.startRecognition(new FileInputStream("speech.wav"));
    SpeechResult result = recognizer.getResult();
    recognizer.stopRecognition();
    
    
    while ((result = recognizer.getResult()) != null) {
      System.out.println(result.getHypothesis());
  }
  }

}
