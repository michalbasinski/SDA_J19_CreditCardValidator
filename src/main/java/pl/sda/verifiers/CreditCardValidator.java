package pl.sda.verifiers;

import pl.sda.checksums.ChecksumVerifier;
import pl.sda.issuers.IssuerDetector;

public class CreditCardValidator implements Validator {

    private ChecksumVerifier checksumVerifier;
    private IssuerDetector issuerDetector;

    public CreditCardValidator(ChecksumVerifier checksumVerifier, IssuerDetector issuerDetector) {
        this.checksumVerifier = checksumVerifier;
        this.issuerDetector = issuerDetector;
    }

    @Override
    public ValidationResult validate(String cardNo) {
        String issuerName = issuerDetector.detect(cardNo);
        boolean isChecksumCorrect = checksumVerifier.verify(cardNo);
        return new ValidationResult(issuerName, isChecksumCorrect);
    }
}
