WinWaitActive("Opening")
Sleep(2000)
Send("{Enter}")
Sleep(1000)

;Opt("WinTitleMatchMode",2)

;if WinWait("File Download", "", 10) Then 
;	WinActivate("File Download") 
;	;ControlClick("File Download","","[CLASS:Button; INSTANCE:1]")
;	send("{TAB 2}")
;	send("{ENTER}")
;		
;	Exit 0 
;EndIf

;Exit 1