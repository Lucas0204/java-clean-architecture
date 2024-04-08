package com.ca.infrastructure.service;

import com.ca.application.gateway.CreateUserGateway;
import com.ca.core.domain.User;
import com.ca.core.domain.Wallet;
import com.ca.infrastructure.mappers.TransactionPinMapper;
import com.ca.infrastructure.mappers.UserMapper;
import com.ca.infrastructure.mappers.WalletMapper;
import com.ca.infrastructure.repository.TransactionPinEntityRepository;
import com.ca.infrastructure.repository.UserEntityRepository;
import com.ca.infrastructure.repository.WalletEntityRepository;

public class CreateUserGatewayImpl implements CreateUserGateway {
    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try {
            var userEntity = userMapper.toUserEntity(user);
            userEntityRepository.save(userEntity);

            var transactionPinEntity = transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin());
            transactionPinEntityRepository.save(transactionPinEntity);

            var walletEntity = walletMapper.toWalletEntity(wallet, userEntity, transactionPinEntity);
            walletEntityRepository.save(walletEntity);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
