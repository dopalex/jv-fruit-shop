package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseHandlerImpl implements OperationHandler {

    private final StorageDao fruitStorageDao;

    public PurchaseHandlerImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        if (Storage.storage.get(fruit) - quantity < 0) {
            throw new RuntimeException("There are no products...");
        }
        fruitStorageDao.take(fruit, quantity);
    }
}
