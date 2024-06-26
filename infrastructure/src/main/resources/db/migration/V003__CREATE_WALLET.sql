CREATE TABLE Wallets(
    Id BIGINT AUTO_INCREMENT,
    Balance DECIMAL(10, 2) NOT NULL,
    UserId UUID NOT NULL UNIQUE,
    TransactionPinId BIGINT NOT NULL UNIQUE,
    CreatedAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt DATETIME,

    PRIMARY KEY (Id),
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (TransactionPinId) REFERENCES TransactionsPin(Id)
);