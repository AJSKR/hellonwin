## 사람 로그  

# Git 초기 작업  
책 보면서 예제 코드를 짜봤음. git 등 vcs 고려 없이 시작하여 로컬에 저장했다가...  
나중에 git 하면서 짜자는 생각이 들어서 아래 과정을 겪었음.  

* git 설치 및 config global : 본진인 git-scm에서 클라이언트 받아서 설치함. (예전보다 옵션과 과정이 복잡해져 있음.)  
`git config --global user.name "AJSKR"` 명령이랑 
`git config --global user.email "ajskr@example.com"` 실행.  
(예전에는 후자 생략 가능했던 것 같은데, 요즘은 다시 따져 묻더라는.)  

* 로컬 해당 경로에서 git 첫걸음  
  * 해당 경로 폴더에 가서 (`cd ~\prj\prjname` 등) `git init` 실행.  
깃왈 "Initialized empty Git repository in 그경로/.git/"  
  * 스테이징을 위해 `git add .` 실행. (MS 윈도우즈 환경이기 때문에 개행문자 이슈 발생)  
깃왈 "warning: LF will be replaced by CRLF in .gitignore. The file will have its original line endings in your working directory" 라는 라인이 파일 갯수만큼 나옴.
  * 상태를 알기 위해 `git status` 실행.  
깃왈 "new file : 파일이름" 이라는 라인이 파일 갯수만큼 나옴. 
  * 첫 커밋을 위해 `git commit -m "first c."` 실행.  
깃왈 "Author identity unknown *** Please tell me who you are." 라며 팅김. 상술했듯 config --global 에서 email 입력 스킵해서 발생한 문제.  
  *  email 설정 후 다시 `git commit -am "first c."` 실행.  
깃왈 "create mode 100644 ..." 라고 파일 갯수만큼 리스트 나오면서 첫 커밋 성공.  

* remote 레파지토리 설정  
이 즈음에서 github에 로그인하여 레파지터리 하나 만들어 둠.  
참고로 readme.md를 안만들면 첫 작업 cli 명령어 안내 화면이 나오고 이후 push도 일사천리임.  
하지만, 상황을 복잡하게 해주는 readme.md 작성 체크를 켰더니... 예전엔 못봤던 branch -> main 설정 내용과 상세 옵션 링크 등도 나옴.  
참고로, empty로 만들면 나오는 명령어 안내 펌 : `git branch -M main` / `git remote add origin https깃헙주소쩜git` / `git push -u origin main` 끗.  

* 첫 push 실패 경험 적어두기  
  * 위에 퍼온 명령어를 차례대로 쳤더니, 잘 되는 듯 하다가 마지막 push에서 에러가 남.  
깃왈 "! [rejected] main -> main (fetch first) error: failed to push some refs to ..." 저쪽에 뭐가 있으니 pull이니 fetch니 먼저 하라는 식.  
  * 그래서 일단 `git pull` 실행하니 잘 실행됨.  
깃왈 "remote: Enumerating objects 어쩌고 Counting objects 저쩌고 compressing, unpacking, 등등 ... done."  
  * 다시 `git push` 시도. 말이 짧다며 잘 안됨.  
깃왈 "There is no tracking information for the current branch. Please specify which branch you want to merge with."
  * 그래서 `git push -u origin main` 이라고 다시 해 봄. (참고로, 이쯤에서 `git push --set-upstream origin main` 라고 치면 `git push`만 쳐도 되게됨.)  
에러 깃왈 "! [rejected] main -> main (non-fast-forward) / error: failed to push some refs to 'https깃헙주소그거'  
  * 정신 차리고 `git remote -v` 등등도 보고 정리 잘 한 다음 다시 pull 해봤더니, 
에러 깃왈 "From https깃헙주소 * branch main -> FETCH_HEAD / fatal: refusing to merge unrelated histories"  
  * 그래서 검색 및 친구 찬스 알현. 다시 `git pull --allow-unrelated-histories origin main` 실행하니까 해결 됨.  
깃왈 "Merge made by the 'ort' strategy. README.md | 2 ++  1 file changed, 2 insertions(+) create mode 100644 README.md"  
  * 그 후 다시 push 하니까 잘 동기화 끝남.  
