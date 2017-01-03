public void displayAnswer(AjaxBehaviorEvent event){
		this.listToDisplayAnswer=null;
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String data =  params.get("questionId");
		
		Integer rowNumber=Integer.parseInt(data);
		
		this.row=rowNumber;
		
		this.questionDesc = finalQuestionList.get(rowNumber).getQuestionDesc();
		this.listToDisplayAnswer=new ArrayList<AnswerBean>();
		
		if(rowNumber!=7){
			for(int i=0;i<finalQuestionAnswerList.get(rowNumber).getAnswer().size();i++){
				AnswerBean a1=new AnswerBean();
				a1.setItem(finalQuestionAnswerList.get(rowNumber).getAnswer().get(i));
				a1.setScoreValue(finalQuestionAnswerList.get(rowNumber).getScoreList().get(i).toString());		
				this.listToDisplayAnswer.add(a1);
			}
		
		}
		else{
			for(int i=0;i<20;i++){
				AnswerBean a1=new AnswerBean();
				a1.setItem(finalQuestionAnswerList.get(rowNumber).getAnswer().get(i));
				a1.setScoreValue(finalQuestionAnswerList.get(rowNumber).getScoreList().get(i).toString());		
				this.listToDisplayAnswer.add(a1);
			}
		}
		rowZipCode=0;
		
		
		
		
	}
	
	
	
	
	public void displayZipCodeNext(AjaxBehaviorEvent event){
		this.listToDisplayAnswer=null;
		this.listToDisplayAnswer=new ArrayList<AnswerBean>();
		
		for(int i=rowZipCode;i<rowZipCode+20;i++){
			AnswerBean a1=new AnswerBean();
			a1.setItem(finalQuestionAnswerList.get(7).getAnswer().get(i));
			a1.setScoreValue(finalQuestionAnswerList.get(7).getScoreList().get(i).toString());		
			this.listToDisplayAnswer.add(a1);
		}
		rowZipCode+=20;
		
		
	}
	
	public void displayZipCodePrevious(AjaxBehaviorEvent event){
		this.listToDisplayAnswer=null;
		this.listToDisplayAnswer=new ArrayList<AnswerBean>();
		if(rowZipCode>20){
		
		for(int i=rowZipCode-40;i<rowZipCode-20;i++){
			AnswerBean a1=new AnswerBean();	
			a1.setItem(finalQuestionAnswerList.get(7).getAnswer().get(i));
			a1.setScoreValue(finalQuestionAnswerList.get(7).getScoreList().get(i).toString());		
			this.listToDisplayAnswer.add(a1);
		}
		rowZipCode-=20;
		}
		
		
		
		
	}
