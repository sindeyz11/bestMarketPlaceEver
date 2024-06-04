import authStore from '@/store/auth'
import { PickupPointItem } from './pickup-point-item'
import { Button } from "../ui/button";

export const PickupPointsList = () => {
  return (
    <div className="bg-white shadow-lg rounded-xl p-6 ">
      <h2 className="text-black font-semibold text-lg mb-2">Пункты выдачи</h2>
      {authStore.pickupPoints.length ? (
        <div className="flex flex-col gap-3">
          {authStore.pickupPoints.map((pickupPoint) => (
            <PickupPointItem
              code={pickupPoint.code}
              address={pickupPoint.address}
              manager={pickupPoint.manager}
              income={pickupPoint.income}
            />
          ))}
          <Button color="dark">Добавить</Button>
        </div>
      ) : (
        <div className="h-[300px] flex flex-col items-center justify-between">
          <p className="text-secondary-text/40 grow-0 h-full flex items-center justify-center">
            Пользователи отсутсвуют
          </p>
          <Button color="dark">Добавить</Button>
        </div>
      )}
    </div>
  );
};
