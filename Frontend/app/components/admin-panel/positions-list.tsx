"use client";

import { IPositionItem } from "@/types";
import { Button } from "../ui/button";
import { PositionItem } from "./position-item";
import Modal from "../layout/modal";
import { useState } from "react";

interface PositionsListProps {
  positions: IPositionItem[];
}

export const PositionsList = ({ positions }: PositionsListProps) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };
  return (
    <div className="bg-white shadow-lg rounded-xl p-6 ">
      <Modal isOpen={isModalOpen} onClose={handleCloseModal}>
        <div className="h-full w-full flex flex-col">
          <div className="flex flex-col gap-3">
            <h3 className="font-semibold text-xl text-center">
              Добавить позицию
            </h3>
            <PositionItem />
            <div className="flex items-center gap-3 w-full">
              <Button color="gray" onClick={() => handleCloseModal()}>
                Отмена
              </Button>
              <Button color="dark">Добавить</Button>
            </div>
          </div>
        </div>
      </Modal>
      <h2 className="text-black font-semibold text-lg mb-2">Позиции</h2>
      {positions.length ? (
        <div className="flex flex-col gap-4">
          <div className="flex flex-col  h-[calc(100dvh-300px)] overflow-y-auto rounded-xl gap-3 custom-scroll">
            {positions.map((position) => (
              <PositionItem
                key={position.id}
                id={position.id}
                title={position.title}
                price={position.price}
                discountPrice={position.discountPrice}
                unit={position.unit}
                availableQuantity={position.availableQuantity}
                description={position.description}
                image={position.image}
                category={position.category}
              />
            ))}
          </div>
          <Button color="dark" onClick={() => handleOpenModal()}>
            Добавить
          </Button>
        </div>
      ) : (
        <div className="flex flex-col  min-h-[calc(100%-30px)]">
          <div className="grow flex items-center justify-center">
            <p className="text-black/40">Позиции отсутствуют</p>
          </div>
          <Button color="dark" onClick={() => handleOpenModal()}>
            Добавить
          </Button>
        </div>
      )}
    </div>
  );
};
