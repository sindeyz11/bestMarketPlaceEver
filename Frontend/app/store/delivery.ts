import { makeAutoObservable } from "mobx";
import authStore from "./auth";
import { IDeliveryItem } from "@/types";

class Delivery {
  deliveryItems: IDeliveryItem[] = authStore.productsAdmin.map((product) => ({
    ...product,
    count: 1,
    status: "в пути",
    dateOrder: new Date().toLocaleDateString(),
    dateDelivery: new Date().toLocaleDateString(),
  }));
  constructor() {
    makeAutoObservable(this);
  }
}

const deliveryStore = new Delivery();
export default deliveryStore;
