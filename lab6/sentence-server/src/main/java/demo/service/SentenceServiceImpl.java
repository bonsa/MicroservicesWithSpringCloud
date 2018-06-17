package demo.service;

import demo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Build a sentence by assembling randomly generated subjects, verbs, 
 * articles, adjectives, and nouns.  The individual parts of speech will 
 * be obtained by calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	private VerbClient verbClient;
	private SubjectClient subjectClient;
	private AdjectiveClient adjectiveClient;
	private ArticleClient articleClient;
	private NounClient nounClient;
	

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence =  
			String.format("%s %s %s %s %s.",
				subjectClient.getWord().getString(),
				verbClient.getWord().getString(),
				adjectiveClient.getWord().getString(),
				articleClient.getWord().getString(),
				nounClient.getWord().getString() );
		return sentence;
	}


	@Autowired
	public void setVerbClient(VerbClient verbClient) {
		this.verbClient = verbClient;
	}

	@Autowired
	public void setSubjectClient(SubjectClient subjectClient) {
		this.subjectClient = subjectClient;
	}

	@Autowired
	public void setAdjectiveClient(AdjectiveClient adjectiveClient) {
		this.adjectiveClient = adjectiveClient;
	}

	@Autowired
	public void setArticleClient(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	@Autowired
	public void setNounClient(NounClient nounClient) {
		this.nounClient = nounClient;
	}	
	
	
}
