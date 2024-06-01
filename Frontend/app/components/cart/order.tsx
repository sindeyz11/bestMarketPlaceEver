import cartStore from "@/store/cart";
import { observer } from "mobx-react-lite";
import { Button } from "../ui/button";

interface OrderProps {
  pickupPointAddress?: string;
  deliveryDate?: string;
}

export const Order = observer(
  ({
    pickupPointAddress = "г. Краснодар, ул. Ставропольская, 149",
    deliveryDate = "2 июня",
  }: OrderProps) => {
    return (
      <div className="bg-white shadow-lg rounded-xl flex flex-col p-6">
        <h3 className="text-lg font-semibold">Оформление заказа</h3>
        <hr className="my-4" />
        <div className="flex flex-col gap-4">
          <div className="flex flex-col gap-2">
            <div className="flex flex-col gap-1">
              <p className="font-semibold">Доставка в пункт выдачи</p>
              <p>{pickupPointAddress}</p>
            </div>
            <div className="flex flex-col gap-1">
              <p className="font-semibold">Дата ближайшей доставки</p>
              <p>{deliveryDate}</p>
            </div>
          </div>
          <div className="flex items-center justify-between font-bold text-lg">
            <span>Итого</span>
            <span className="flex items-center">
              ₽
              <span className="text-dark-accent">
                {Intl.NumberFormat("ru", {
                  style: "decimal",
                  minimumFractionDigits: 2,
                  maximumFractionDigits: 2,
                }).format(cartStore.getTotalPrice())}
              </span>
            </span>
          </div>
          <Button color="dark">Заказать</Button>
        </div>
      </div>
    );
  },
);
