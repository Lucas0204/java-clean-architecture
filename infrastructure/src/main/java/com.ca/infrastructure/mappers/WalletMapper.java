package com.ca.infrastructure.mappers;

import com.ca.core.domain.Wallet;
import com.ca.infrastructure.entity.TransactionPinEntity;
import com.ca.infrastructure.entity.UserEntity;
import com.ca.infrastructure.entity.WalletEntity;

public class WalletMapper {
    public WalletEntity toWalletEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPin) {
        return new WalletEntity(
            wallet.getBalance(),
            user,
            transactionPin,
            wallet.getCreatedAt(),
            wallet.getUpdatedAt()
        );
    }
}
