import { PickupPointsList } from "@/components/admin-panel/pickup-points-list"
import { PositionsList } from "@/components/admin-panel/positions-list"
import { UsersList } from "@/components/admin-panel/users-list";
import authStore from "@/store/auth";

const AdminPanelPage = () => {
  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex py-10 bg-[#F6F6F6]"
    >
      <title>Админ-панель</title>
      <div className="w-full grid grid-cols-3 px-20 gap-6 h-full">
        <div className="col-span-1">
          <PositionsList positions={authStore.productsAdmin} />
        </div>
        <div className="col-span-1">
          <PickupPointsList />
        </div>
        <div className="col-span-1">
          <UsersList />
        </div>
      </div>
    </div>
  );
};

export default AdminPanelPage
