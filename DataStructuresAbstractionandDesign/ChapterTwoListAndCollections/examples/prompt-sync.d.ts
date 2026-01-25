declare module "prompt-sync" {
    function promptSync(): (question: string) => string;
    export default promptSync;
}
