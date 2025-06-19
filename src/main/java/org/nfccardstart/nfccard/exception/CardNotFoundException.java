package org.nfccardstart.nfccard.exception;




public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String message) {
        super(message);
    }
}