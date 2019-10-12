package pl.sda;

import pl.sda.checksums.ChecksumVerifier;
import pl.sda.checksums.LuhnVerifier;
import pl.sda.issuers.IssuerDetector;
import pl.sda.issuers.IssuerRuleFileRepository;
import pl.sda.issuers.IssuerRuleRepository;
import pl.sda.verifiers.CreditCardValidator;
import pl.sda.verifiers.ValidationResult;

// git remote update origin --prune
// git merge origin/develop

public class App
{
    public static void main( String[] args ) {

        String cardNo = "5501149031856642";

        IssuerRuleRepository fileRepository
                = new IssuerRuleFileRepository("/home/michal/SDA/Java19/Projekty/cards/src/main/resources/rules.json");
        IssuerDetector detector = new IssuerDetector(fileRepository);
        ChecksumVerifier checksumVerifier = new LuhnVerifier();
        CreditCardValidator validator = new CreditCardValidator(checksumVerifier, detector);
        ValidationResult result = validator.validate(cardNo);

        System.out.println("Wynik walidacji numeru " + cardNo);
        System.out.println("Wystawca: " + result.getIssuerName());
        System.out.println("Cyfra kontrolna poprawna: " + result.isChecksumVerified());
    }
}
