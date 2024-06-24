"use client";

import { useState } from "react";
import { useMutation, useQuery } from "@tanstack/react-query";
import authStore from "@/store/auth";
import PointsService from "@/app/api/points-service";
import { PickupPointItem } from "./pickup-point-item";
import { Button } from "../ui/button";
import Modal from "../layout/modal";
import { AddingPickupPoint } from "./adding-pickup-point";
import { Loading } from "../layout/loading";

export const PickupPointsList = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["points"],
    queryFn: async () => {
      const response = await PointsService.getAllPoints();
      return response.data; // убедитесь, что `response.data` возвращает ожидаемый массив данных
    },
  });

  const allPoints = data;
  console.log(allPoints);

  const handleOpenModal = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };

  if (isLoading) {
    return <Loading />;
  }

  if (isError) {
    return (
      <div className="flex h-screen w-full items-center justify-center bg-accent">
        <p className="text-red-500">Ошибка загрузки данных: {error.message}</p>
      </div>
    );
  }

  return (
    <div className="rounded-xl bg-white p-6 shadow-lg">
      <Modal isOpen={isModalOpen} onClose={handleCloseModal}>
        <div className="flex h-full w-full flex-col">
          <div className="flex flex-col gap-3">
            <h3 className="text-center text-xl font-semibold">
              Добавить пункт выдачи
            </h3>
            <AddingPickupPoint />
            <div className="flex w-full items-center gap-3">
              <Button color="gray" onClick={handleCloseModal}>
                Отмена
              </Button>
              <Button color="dark">Добавить</Button>
            </div>
          </div>
        </div>
      </Modal>
      <h2 className="mb-2 text-lg font-semibold text-black">Пункты выдачи</h2>
      {allPoints && allPoints.length > 0 ? (
        <div className="flex flex-col gap-3">
          {allPoints.map((pickupPoint) => (
            <PickupPointItem
              key={pickupPoint?.id} // добавьте уникальный ключ для каждого элемента
              code={pickupPoint?.id}
              address={pickupPoint?.address}
              manager={pickupPoint?.manager_name}
              income={pickupPoint?.income}
            />
          ))}
          <Button color="dark" onClick={handleOpenModal}>
            Добавить
          </Button>
        </div>
      ) : (
        <div className="flex h-[300px] flex-col items-center justify-between">
          <p className="flex h-full grow-0 items-center justify-center text-secondary-text/40">
            Пункты выдачи отсутствуют
          </p>
          <Button color="dark" onClick={handleOpenModal}>
            Добавить
          </Button>
        </div>
      )}
    </div>
  );
};
