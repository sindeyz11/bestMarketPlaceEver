import { IPickupPoint } from "@/types";

export const PickupPoint = ({ point }: { point: IPickupPoint | undefined }) => {
  return (
    <div className="bg-white shadow-lg rounded-xl p-6">
      <div className="flex flex-col gap-3">
        <h3 className="font-semibold text-lg">Пункт выдачи</h3>
        <div className="flex flex-col gap-1">
          <h4 className="font-semibold">Адрес пункта выдачи</h4>
          <p>{point?.address}</p>
        </div>
        <div className="flex flex-col">
          <h4 className="font-semibold">Индетефикатор пункта выдачи</h4>
          <p>{point?.code}</p>
        </div>
        <div className="flex flex-col">
          <h4 className="font-semibold">Менеджер пункта выдачи</h4>
          <p>{point?.manager.name}</p>
        </div>
      </div>
    </div>
  );
};
