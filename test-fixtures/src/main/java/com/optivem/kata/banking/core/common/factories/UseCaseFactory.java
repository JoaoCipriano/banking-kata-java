package com.optivem.kata.banking.core.common.factories;

import an.awesome.pipelinr.Command;
import com.optivem.kata.banking.core.ports.driven.AccountIdGenerator;
import com.optivem.kata.banking.core.ports.driven.AccountNumberGenerator;
import com.optivem.kata.banking.core.ports.driven.BankAccountStorage;
import com.optivem.kata.banking.core.ports.driven.CustomerGateway;
import com.optivem.kata.banking.core.ports.driven.DateTimeService;
import com.optivem.kata.banking.core.ports.driven.EventBus;
import com.optivem.kata.banking.core.ports.driven.NationalIdentityGateway;
import com.optivem.kata.banking.core.ports.driver.VoidResponse;
import com.optivem.kata.banking.core.ports.driver.accounts.depositfunds.DepositFundsRequest;
import com.optivem.kata.banking.core.ports.driver.accounts.openaccount.OpenAccountRequest;
import com.optivem.kata.banking.core.ports.driver.accounts.openaccount.OpenAccountResponse;
import com.optivem.kata.banking.core.ports.driver.accounts.withdrawfunds.WithdrawFundsRequest;

public interface UseCaseFactory {

    Command.Handler<OpenAccountRequest, OpenAccountResponse> createOpenAccountHandler(NationalIdentityGateway nationalIdentityGateway, CustomerGateway customerGateway, BankAccountStorage bankAccountStorage,
                                                                                      AccountIdGenerator accountIdGenerator, AccountNumberGenerator accountNumberGenerator, DateTimeService dateTimeService, EventBus eventBus);

    Command.Handler<DepositFundsRequest, VoidResponse> createDepositFundsHandler(BankAccountStorage bankAccountStorage, AccountIdGenerator accountIdGenerator, AccountNumberGenerator accountNumberGenerator, DateTimeService dateTimeService, EventBus eventBus);

    Command.Handler<WithdrawFundsRequest, VoidResponse> createWithdrawFundsHandler(BankAccountStorage bankAccountStorage, AccountIdGenerator accountIdGenerator, AccountNumberGenerator accountNumberGenerator, DateTimeService dateTimeService, EventBus eventBus);
}
