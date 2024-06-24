export const Loading = () => {
  return (
    <div className="flex h-screen w-full items-center justify-center rounded-xl bg-white">
      <div className="flex items-center gap-2">
        <img className="h-6 w-6" src="/red-loader.svg" alt="loader" />
        <p>Загрузка...</p>
      </div>
    </div>
  );
};
