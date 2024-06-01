"use client";

import cartStore from "@/store/cart";
import { observer } from "mobx-react-lite";
import { CartItem } from "./cart-item";

export const CartList = observer(() => {
  return (
    <div className="bg-white rounded-xl shadow-lg p-6 flex flex-col">
      <h3 className="text-lg font-semibold">Корзина</h3>
      <hr className="my-4" />
      <div>
        {cartStore.items.length ? (
          <ul className="flex flex-col overflow-y-auto gap-2">
            {cartStore.items.map((item) => (
              <CartItem
                id={item.id}
                title={item.title}
                image={item.image}
                quantity={item.quantity}
                price={item.price}
                discountPrice={item.discountPrice}
                unit={item.unit}
                availableQuantity={item.availableQuantity}
                description={item.description}
              />
            ))}
          </ul>
        ) : (
          <div className="h-48 w-full flex items-center justify-center">
            <p className="text-black/40">В Вашей корзине ничего нет</p>
          </div>
        )}
      </div>
    </div>
  );
});
