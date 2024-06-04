"use client";

import { formatNumber } from "@/utils";
import { Field } from "../ui/field";
import deliveryStore from "@/store/delivery";
import { Button } from "../ui/button";
import { IssuingOrderItem } from "./issuing-order-item";
import { observer } from "mobx-react-lite";

export const IssuingOrder = observer(() => {
  return (
    <div className="bg-white shadow-lg rounded-xl p-6">
      <div className="flex flex-col gap-3">
        <div className="flex flex-col gap-3">
          <div className="flex items-center justify-between w-full">
            <h3 className="font-semibold text-lg">Выдача заказа</h3>
            <div className="w-32">
              <Field startContent="№" placeholder="XXX-XXX" />
            </div>
          </div>
        </div>
        <div className="flex flex-col gap-1">
          {deliveryStore.deliveryItems.map((item) => (
            <IssuingOrderItem key={item.id} {...item} />
          ))}
        </div>
        <div className="flex items-center justify-between w-full">
          <div className="flex flex-col leading-0">
            <h3 className="font-semibold text-lg">Итого</h3>
            <p className="text-sm font-semibold text-secondary-text/60">
              Всего {deliveryStore.deliveryItems.length} позиции (
              {deliveryStore.returnsCount} возврат,{" "}
              {deliveryStore.selectedItems.length} получение)
            </p>
          </div>
          <h3 className="text-xl font-bold">
            ₽{formatNumber(deliveryStore.totalPrice)}
          </h3>
        </div>
        <Button color="dark">Завершить</Button>
      </div>
    </div>
  );
});
