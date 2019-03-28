package InventorySystem.Repository;

import InventorySystem.Object.Purchaces;

import org.springframework.stereotype.Repository;

@Repository
interface PurchasesRepository extends MyBaseRepository<Purchaces, Long>  {
    //Purchaces findById(ID);
}
