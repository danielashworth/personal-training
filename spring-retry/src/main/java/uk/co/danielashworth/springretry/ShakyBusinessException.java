package uk.co.danielashworth.springretry;

class ShakyBusinessException extends RuntimeException {

  ShakyBusinessException(String errorMessage) {
    super(errorMessage);
  }
}
